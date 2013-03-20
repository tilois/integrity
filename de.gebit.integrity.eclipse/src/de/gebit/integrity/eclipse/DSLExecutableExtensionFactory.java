/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider (GEBIT Solutions GmbH) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
/*
 * generated by Xtext
 */
package de.gebit.integrity.eclipse;

import org.osgi.framework.Bundle;

/**
 * This is an extension of {@link de.gebit.integrity.ui.DSLExecutableExtensionFactory} which pretty much serves the same
 * purpose, just in a different Eclipse plugin.
 * 
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class DSLExecutableExtensionFactory extends de.gebit.integrity.ui.DSLExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return Activator.getInstance().getBundle();
	}

}
