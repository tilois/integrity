/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider (GEBIT Solutions GmbH) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
// CHECKSTYLE:OFF
/* 
 * generated by Xtext
 */
package de.gebit.integrity.generator;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;

/**
 * The main class for the generation of code from the Integrity grammar description.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */

public class Main {

	public static void main(String[] someArgs) {
		if (someArgs.length == 0) {
			System.err.println("Aborting: no path to EMF resource provided!");
			return;
		}
		Injector tempInjector = new de.gebit.integrity.DSLStandaloneSetupGenerated()
				.createInjectorAndDoEMFRegistration();
		Main tempMain = tempInjector.getInstance(Main.class);
		tempMain.runGenerator(someArgs[0]);
	}

	@Inject
	private Provider<ResourceSet> resourceSetProvider;

	@Inject
	private IResourceValidator validator;

	@Inject
	private IGenerator generator;

	@Inject
	private JavaIoFileSystemAccess fileAccess;

	protected void runGenerator(String aString) {
		// load the resource
		ResourceSet tempSet = resourceSetProvider.get();
		Resource tempResource = tempSet.getResource(URI.createURI(aString), true);

		// validate the resource
		List<Issue> tempList = validator.validate(tempResource, CheckMode.ALL, CancelIndicator.NullImpl);
		if (!tempList.isEmpty()) {
			for (Issue tempIssue : tempList) {
				System.err.println(tempIssue);
			}
			return;
		}

		// configure and start the generator
		fileAccess.setOutputPath("src-gen/");
		generator.doGenerate(tempResource, fileAccess);

		System.out.println("Code generation finished.");
	}
}
