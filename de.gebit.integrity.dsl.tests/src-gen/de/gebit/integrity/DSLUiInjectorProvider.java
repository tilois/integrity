/*
* generated by Xtext
*/
package de.gebit.integrity;

import org.eclipse.xtext.junit4.IInjectorProvider;

import com.google.inject.Injector;

public class DSLUiInjectorProvider implements IInjectorProvider {
	
	public Injector getInjector() {
		return de.gebit.integrity.ui.internal.DSLActivator.getInstance().getInjector("de.gebit.integrity.DSL");
	}
	
}