/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner.forking;

/**
 * A forker is an implementation of an execution forking mechanism. Its task is to create another process, which ideally
 * is an exact clone of the current (parent) process. The idea is similar to a UNIX fork, but the child process is
 * expected to start "fresh" instead of continuing at the current instruction.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public interface Forker {

	/**
	 * System parameter name for the remoting port to use to communicate with the fork.
	 */
	String SYSPARAM_FORK_REMOTING_PORT = "integrity.fork.port";

	/**
	 * System parameter name for the fork name.
	 */
	String SYSPARAM_FORK_NAME = "integrity.fork.name";

	/**
	 * System parameter for the forks' RNG seed.
	 */
	String SYSPARAM_FORK_SEED = "integrity.fork.seed";

	/**
	 * Performs the actual forking.
	 * 
	 * @param someCommandLineArguments
	 *            the original command line arguments given to the JVM of the parent process
	 * @param aForkName
	 *            the name of the fork
	 * @param aRandomSeed
	 *            the seed for the RNG of the fork
	 * @return the newly created process
	 * @throws ForkException
	 *             if something goes wrong
	 */
	ForkedProcess fork(String[] someCommandLineArguments, String aForkName, long aRandomSeed) throws ForkException;

}
