package de.gebit.integrity.ui.documentation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.util.jdt.IJavaElementFinder;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;

import com.google.inject.Inject;

import de.gebit.integrity.dsl.CallDefinition;
import de.gebit.integrity.dsl.TestDefinition;
import de.gebit.integrity.utils.JavadocUtil;

/**
 * The documentation provider. This provides texts for quick help displays, like in mouseovers.
 * 
 * @author Rene Schneider (rene.schneider@gebit.de)
 * 
 */
public class IntegrityEObjectDocumentationProvider implements IEObjectDocumentationProvider {

	/**
	 * The element finder.
	 */
	@Inject
	IJavaElementFinder elementFinder;

	/**
	 * Returns the documentation text for a specific object.
	 */
	public String getDocumentation(EObject anObject) {
		if (anObject instanceof TestDefinition) {
			TestDefinition tempTestDefinition = (TestDefinition) anObject;
			String tempJavadoc = JavadocUtil.getMethodJavadoc(tempTestDefinition.getFixtureMethod().getMethod(),
					elementFinder);
			return tempJavadoc;
		} else if (anObject instanceof CallDefinition) {
			CallDefinition tempCallDefinition = (CallDefinition) anObject;
			String tempJavadoc = JavadocUtil.getMethodJavadoc(tempCallDefinition.getFixtureMethod().getMethod(),
					elementFinder);
			return tempJavadoc;
		}

		return null;
	}

}
