/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.remoting.transport;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import de.gebit.integrity.remoting.transport.messages.AbstractMessage;

/**
 * A server endpoint. This endpoint listens on a specified port and host IP for incoming connections from client
 * endpoints. When a connection is established, it spawns a new {@link Endpoint} for that specific connection and
 * continues listening for more connections.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class ServerEndpoint {

	/**
	 * The server socket.
	 */
	private ServerSocket serverSocket;

	/**
	 * The message processor map.
	 */
	private Map<Class<? extends AbstractMessage>, MessageProcessor<?>> messageProcessors;

	/**
	 * The thread waiting for incoming connections.
	 */
	private ConnectionWaiter connectionWaiter;

	/**
	 * A list of active endpoints.
	 */
	private List<Endpoint> endpoints = new LinkedList<Endpoint>();

	/**
	 * Whether this server endpoint is in the process of termination.
	 */
	private boolean closing;

	/**
	 * Creates a new server endpoint that listens on a specified port/IP.
	 * 
	 * @param aHostIP
	 *            the host IP to listen on
	 * @param aPort
	 *            the port to bind to
	 * @param aProcessorMap
	 *            the map of processors to use for processing incoming messages
	 * @param aClassLoader
	 *            the classloader to use when deserializing objects
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	public ServerEndpoint(String aHostIP, int aPort,
			Map<Class<? extends AbstractMessage>, MessageProcessor<?>> aProcessorMap, ClassLoader aClassLoader)
			throws UnknownHostException, IOException {
		messageProcessors = aProcessorMap;
		serverSocket = new ServerSocket(aPort, 0, Inet4Address.getByName(aHostIP));
		connectionWaiter = new ConnectionWaiter(aClassLoader);
		connectionWaiter.start();
	}

	public boolean isActive() {
		return serverSocket.isBound() && !serverSocket.isClosed();
	}

	/**
	 * Closes the server endpoint and all endpoints currently active.
	 * 
	 * @param anEmptyOutputQueueFlag
	 *            whether output queues to the endpoints shall be emptied before closing the connection.
	 */
	public void closeAll(boolean anEmptyOutputQueueFlag) {
		if (isActive()) {
			closing = true;
			try {
				serverSocket.close();
			} catch (IOException exc) {
				// don't care
			}

			synchronized (endpoints) {
				for (Endpoint tempEndpoint : endpoints) {
					if (tempEndpoint.isActive()) {
						tempEndpoint.close(anEmptyOutputQueueFlag);
					}
				}
				endpoints.clear();
			}
		}
	}

	private class ConnectionWaiter extends Thread {

		/**
		 * The classloader to use when deserializing objects.
		 */
		private ClassLoader classLoader;

		/**
		 * Creates a new instance.
		 * 
		 * @param aClassLoader
		 *            the classloader to use when deserializing objects
		 */
		public ConnectionWaiter(ClassLoader aClassLoader) {
			super("Server Endpoint Connection Waiter");
			classLoader = aClassLoader;
		}

		@Override
		public void run() {
			while (isActive()) {
				try {
					Socket tempSocket = serverSocket.accept();
					tempSocket.setSoLinger(true, 60);
					synchronized (endpoints) {
						endpoints.add(new Endpoint(tempSocket, messageProcessors, new EndpointListener() {

							@Override
							public void onConnectionLost(Endpoint anEndpoint) {
								synchronized (endpoints) {
									endpoints.remove(anEndpoint);
								}
							}

							@Override
							public void onClosed(Endpoint anEndpoint) {
								// we'll remove it in the outer class
							}

						}, classLoader));
					}
				} catch (IOException exc) {
					if (!closing) {
						exc.printStackTrace();
					}
				}
			}
		}
	}

	/**
	 * Broadcasts a message to all active endpoints.
	 * 
	 * @param aMessage
	 *            the message
	 */
	public void broadcastMessage(AbstractMessage aMessage) {
		synchronized (endpoints) {
			for (Endpoint tempEndpoint : endpoints) {
				if (tempEndpoint.isActive()) {
					tempEndpoint.sendMessage(aMessage);
				}
			}
		}
	}

}
