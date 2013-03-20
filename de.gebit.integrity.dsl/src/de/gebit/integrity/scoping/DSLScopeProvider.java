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
package de.gebit.integrity.scoping;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.scoping.impl.SimpleScope;

import de.gebit.integrity.dsl.Call;
import de.gebit.integrity.dsl.ConstantDefinition;
import de.gebit.integrity.dsl.FixedParameterName;
import de.gebit.integrity.dsl.ForkDefinition;
import de.gebit.integrity.dsl.ForkParameter;
import de.gebit.integrity.dsl.MethodReference;
import de.gebit.integrity.dsl.Parameter;
import de.gebit.integrity.dsl.ParameterName;
import de.gebit.integrity.dsl.ParameterTableHeader;
import de.gebit.integrity.dsl.Suite;
import de.gebit.integrity.dsl.SuiteDefinition;
import de.gebit.integrity.dsl.SuiteParameter;
import de.gebit.integrity.dsl.TableTest;
import de.gebit.integrity.dsl.Test;
import de.gebit.integrity.dsl.VariableDefinition;
import de.gebit.integrity.dsl.VariableOrConstantEntity;
import de.gebit.integrity.fixtures.FixtureMethod;
import de.gebit.integrity.utils.IntegrityDSLUtil;
import de.gebit.integrity.utils.ParamAnnotationTypeTriplet;
import de.gebit.integrity.utils.ResultFieldTuple;

/**
 * This class contains custom scoping description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping on how and when to use it
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class DSLScopeProvider extends AbstractDeclarativeScopeProvider {

	/**
	 * Limits the fixed parameter names to those defined in a fixture method signature.
	 * 
	 * @param aParameterName
	 * @param aRef
	 * @return
	 */
	// SUPPRESS CHECKSTYLE MethodName
	public IScope scope_FixedParameterName_annotation(FixedParameterName aParameterName, EReference aRef) {
		MethodReference tempMethodRef = null;
		if (aParameterName.eContainer() instanceof Parameter) {
			Parameter tempParameter = (Parameter) aParameterName.eContainer();

			if (tempParameter.eContainer() instanceof Test) {
				tempMethodRef = ((Test) tempParameter.eContainer()).getDefinition().getFixtureMethod();
			} else if (tempParameter.eContainer() instanceof Call) {
				tempMethodRef = ((Call) tempParameter.eContainer()).getDefinition().getFixtureMethod();
			} else if (tempParameter.eContainer() instanceof TableTest) {
				tempMethodRef = ((TableTest) tempParameter.eContainer()).getDefinition().getFixtureMethod();
			}
		} else if (aParameterName.eContainer() instanceof ParameterTableHeader) {
			ParameterTableHeader tempParameterHeader = (ParameterTableHeader) aParameterName.eContainer();

			if (tempParameterHeader.eContainer() instanceof TableTest) {
				tempMethodRef = ((TableTest) tempParameterHeader.eContainer()).getDefinition().getFixtureMethod();
			}
		} else if (aParameterName.eContainer() instanceof ForkParameter) {
			ForkParameter tempForkParameter = (ForkParameter) aParameterName.eContainer();
			ForkDefinition tempForkDef = (ForkDefinition) tempForkParameter.eContainer();

			if (tempForkDef.getForkerClass() != null
					&& (tempForkDef.getForkerClass().getType() instanceof JvmGenericType)) {
				ArrayList<IEObjectDescription> tempList = new ArrayList<IEObjectDescription>();
				List<ParamAnnotationTypeTriplet> tempParamList = IntegrityDSLUtil
						.getAllParamNamesFromForker((JvmGenericType) tempForkDef.getForkerClass().getType());

				for (ParamAnnotationTypeTriplet tempParam : tempParamList) {
					tempList.add(EObjectDescription.create(tempParam.getParamName(), tempParam.getAnnotation()));
				}

				return new SimpleScope(tempList);
			}
		}

		if (tempMethodRef != null) {
			ArrayList<IEObjectDescription> tempList = new ArrayList<IEObjectDescription>();
			List<ParamAnnotationTypeTriplet> tempParamList = IntegrityDSLUtil
					.getAllParamNamesFromFixtureMethod(tempMethodRef);
			for (ParamAnnotationTypeTriplet tempParam : tempParamList) {
				tempList.add(EObjectDescription.create(tempParam.getParamName(), tempParam.getAnnotation()));
			}

			return new SimpleScope(tempList);
		}

		return IScope.NULLSCOPE;
	}

	/**
	 * Limits the fixture method references to actually existing methods with the necessary annotation.
	 * 
	 * 
	 * @param aMethodRef
	 * @param aRef
	 * @return
	 */
	// SUPPRESS CHECKSTYLE MethodName
	public IScope scope_MethodReference_method(MethodReference aMethodRef, EReference aRef) {
		JvmType tempType = aMethodRef.getType();
		List<IEObjectDescription> tempDescriptions = new ArrayList<IEObjectDescription>();

		if (tempType instanceof JvmGenericType) {
			JvmGenericType tempTypeInFocus = (JvmGenericType) tempType;

			while (tempTypeInFocus != null) {
				for (JvmMember tempMember : tempTypeInFocus.getMembers()) {
					if (tempMember instanceof JvmOperation
							&& ((JvmOperation) tempMember).getVisibility() == JvmVisibility.PUBLIC) {
						boolean tempIsFixtureMethod = false;
						for (JvmAnnotationReference tempAnnotation : tempMember.getAnnotations()) {
							if (FixtureMethod.class.getName().equals(tempAnnotation.getAnnotation().getQualifiedName())) {
								tempIsFixtureMethod = true;
								break;
							}
						}
						if (tempIsFixtureMethod) {
							tempDescriptions.add(EObjectDescription.create(
									QualifiedName.create(((JvmOperation) tempMember).getSimpleName()), tempMember));
						}
					}
				}

				JvmGenericType tempOldType = tempTypeInFocus;
				tempTypeInFocus = null;
				for (JvmTypeReference tempSuperType : tempOldType.getSuperTypes()) {
					if ((tempSuperType.getType() instanceof JvmGenericType)
							&& !((JvmGenericType) tempSuperType.getType()).isInterface()) {
						tempTypeInFocus = (JvmGenericType) tempSuperType.getType();
						break;
					}
				}
			}
		}
		return new SimpleScope(tempDescriptions);
	}

	/**
	 * Limits suite parameters to actually defined parameters.
	 * 
	 * @param aParameter
	 * @param aRef
	 * @return
	 */
	// SUPPRESS CHECKSTYLE MethodName
	public IScope scope_SuiteParameter_name(SuiteParameter aParameter, EReference aRef) {
		SuiteDefinition tempSuiteDef = (SuiteDefinition) ((Suite) aParameter.eContainer()).getDefinition();

		if (tempSuiteDef != null) {
			ArrayList<IEObjectDescription> tempList = new ArrayList<IEObjectDescription>();
			for (VariableOrConstantEntity tempParam : tempSuiteDef.getParameters()) {
				tempList.add(EObjectDescription.create(tempParam.getName(), tempParam));
			}

			return new SimpleScope(tempList);
		}

		return IScope.NULLSCOPE;
	}

	/**
	 * Limits enumeration values in parameters to actually existent enumeration literals.
	 * 
	 * @param aParameter
	 * @param aRef
	 * @return
	 */
	// SUPPRESS CHECKSTYLE MethodName
	public IScope scope_EnumValue_enumValue(Parameter aParameter, EReference aRef) {
		MethodReference tempMethodRef = null;
		if (aParameter.eContainer() instanceof Test) {
			tempMethodRef = ((Test) aParameter.eContainer()).getDefinition().getFixtureMethod();
		} else if (aParameter.eContainer() instanceof Call) {
			tempMethodRef = ((Call) aParameter.eContainer()).getDefinition().getFixtureMethod();
		}

		ParameterName tempParamName = aParameter.getName();

		if (tempParamName instanceof FixedParameterName) {
			JvmAnnotationReference tempAnnotationRef = ((FixedParameterName) tempParamName).getAnnotation();

			if (tempMethodRef != null && tempAnnotationRef != null) {
				ArrayList<IEObjectDescription> tempList = new ArrayList<IEObjectDescription>();
				List<JvmEnumerationLiteral> tempLiteralList = IntegrityDSLUtil
						.getAllEnumLiteralsFromFixtureMethodParam(tempMethodRef, tempAnnotationRef);
				if (tempLiteralList != null) {
					for (JvmEnumerationLiteral tempLiteral : tempLiteralList) {
						tempList.add(EObjectDescription.create(tempLiteral.getSimpleName(), tempLiteral));
					}

					return new SimpleScope(tempList);
				}
			}
		} else {
			// TODO add arbitrary parameter name path
		}

		return IScope.NULLSCOPE;
	}

	/**
	 * Limit enum values in test results to actually existent enumeration literals.
	 * 
	 * @param aTest
	 * @param aRef
	 * @return
	 */
	// SUPPRESS CHECKSTYLE MethodName
	public IScope scope_EnumValue_enumValue(Test aTest, EReference aRef) {
		MethodReference tempMethodRef = aTest.getDefinition().getFixtureMethod();

		if (tempMethodRef != null) {
			ArrayList<IEObjectDescription> tempList = new ArrayList<IEObjectDescription>();
			List<JvmEnumerationLiteral> tempLiteralList = IntegrityDSLUtil
					.getAllEnumLiteralsFromJvmTypeReference(tempMethodRef.getMethod().getReturnType());
			if (tempLiteralList != null) {
				for (JvmEnumerationLiteral tempLiteral : tempLiteralList) {
					tempList.add(EObjectDescription.create(tempLiteral.getSimpleName(), tempLiteral));
				}

				return new SimpleScope(tempList);
			}
		}

		return IScope.NULLSCOPE;
	}

	/**
	 * Limit named test results to actually existing fields in the result container object.
	 * 
	 * @param aTest
	 * @param aRef
	 * @return
	 */
	// SUPPRESS CHECKSTYLE MethodName
	public IScope scope_FixedResultName_field(Test aTest, EReference aRef) {
		MethodReference tempMethodRef = aTest.getDefinition().getFixtureMethod();

		if (tempMethodRef != null) {
			ArrayList<IEObjectDescription> tempList = new ArrayList<IEObjectDescription>();
			List<ResultFieldTuple> tempResultFields = IntegrityDSLUtil
					.getAllResultNamesFromFixtureMethod(tempMethodRef);
			for (ResultFieldTuple tempResultField : tempResultFields) {
				tempList.add(EObjectDescription.create(tempResultField.getResultName(), tempResultField.getField()));
			}

			return new SimpleScope(tempList);
		}

		return IScope.NULLSCOPE;
	}

	/**
	 * Limit named test results to actually existing fields in the result container object.
	 * 
	 * @param aCall
	 * @param aRef
	 * @return
	 */
	// SUPPRESS CHECKSTYLE MethodName
	public IScope scope_FixedResultName_field(Call aCall, EReference aRef) {
		MethodReference tempMethodRef = aCall.getDefinition().getFixtureMethod();

		if (tempMethodRef != null) {
			ArrayList<IEObjectDescription> tempList = new ArrayList<IEObjectDescription>();
			List<ResultFieldTuple> tempResultFields = IntegrityDSLUtil
					.getAllResultNamesFromFixtureMethod(tempMethodRef);
			for (ResultFieldTuple tempResultField : tempResultFields) {
				tempList.add(EObjectDescription.create(tempResultField.getResultName(), tempResultField.getField()));
			}

			return new SimpleScope(tempList);
		}

		return IScope.NULLSCOPE;
	}

	/**
	 * Limit named test results to actually existing fields in the result container object.
	 * 
	 * @param aTableTest
	 * @param aRef
	 * @return
	 */
	// SUPPRESS CHECKSTYLE MethodName
	public IScope scope_FixedResultName_field(TableTest aTableTest, EReference aRef) {
		MethodReference tempMethodRef = aTableTest.getDefinition().getFixtureMethod();

		if (tempMethodRef != null) {
			ArrayList<IEObjectDescription> tempList = new ArrayList<IEObjectDescription>();
			List<ResultFieldTuple> tempResultFields = IntegrityDSLUtil
					.getAllResultNamesFromFixtureMethod(tempMethodRef);
			for (ResultFieldTuple tempResultField : tempResultFields) {
				tempList.add(EObjectDescription.create(tempResultField.getResultName(), tempResultField.getField()));
			}

			return new SimpleScope(tempList);
		}

		return IScope.NULLSCOPE;
	}

	/**
	 * Limit result variables for calls to actual variables.
	 * 
	 * @param aCall
	 * @param aRef
	 * @return
	 */
	// SUPPRESS CHECKSTYLE MethodName
	public IScope scope_Variable_name(Call aCall, EReference aRef) {
		IScope tempScope = super.delegateGetScope(aCall, aRef);

		// fetch the host suite of the call
		SuiteDefinition tempHostSuite = (SuiteDefinition) aCall.eContainer();

		return filterVariableScope(tempScope, tempHostSuite, aCall);
	}

	/**
	 * Prevents variables in parameters from being influenced by {@link #scope_Variable_name(Call, EReference)}, and
	 * filters out variables defined as suite parameters in other suites.
	 * 
	 * @param aParam
	 * @param aRef
	 * @return
	 */
	// SUPPRESS CHECKSTYLE MethodName
	public IScope scope_Variable_name(Parameter aParam, EReference aRef) {
		IScope tempScope = super.delegateGetScope(aParam, aRef);

		// fetch the host suite of the parameter (should be correct for calls, tabletests and tests)
		SuiteDefinition tempHostSuite = (SuiteDefinition) aParam.eContainer().eContainer();

		return filterVariableScope(tempScope, tempHostSuite, aParam);
	}

	/**
	 * Filters out variables defined as suite parameters or local variables in other suites.
	 * 
	 * @param aTableTestRow
	 * @param aRef
	 * @return
	 */
	// SUPPRESS CHECKSTYLE MethodName
	public IScope scope_Variable_name(TableTest aTableTest, EReference aRef) {
		IScope tempScope = super.delegateGetScope(aTableTest, aRef);

		SuiteDefinition tempHostSuite = (SuiteDefinition) aTableTest.eContainer();

		return filterVariableScope(tempScope, tempHostSuite, aTableTest);
	}

	private IScope filterVariableScope(IScope aScope, SuiteDefinition aCurrentSuite, EObject aContext) {
		ArrayList<IEObjectDescription> tempList = new ArrayList<IEObjectDescription>();
		for (IEObjectDescription tempElement : aScope.getAllElements()) {
			EObject tempEObject = tempElement.getEObjectOrProxy();
			if (tempEObject.eIsProxy()) {
				tempEObject = EcoreUtil.resolve(tempEObject, aContext);
				if (tempEObject == null) {
					continue;
				}
			}

			EObject tempDefContainer = tempEObject.eContainer();

			if (tempDefContainer instanceof SuiteDefinition) {
				// this is a suite param -> must be the current suite
				if (tempDefContainer != aCurrentSuite) {
					continue;
				}
			} else if (tempDefContainer instanceof VariableDefinition || tempDefContainer instanceof ConstantDefinition) {
				EObject tempDefDefContainer = tempDefContainer.eContainer();
				if (tempDefDefContainer instanceof SuiteDefinition) {
					// variable / constant defined in a suite -> must be the current suite!
					if (tempDefDefContainer != aCurrentSuite) {
						continue;
					}
				}
			}
			tempList.add(tempElement);
		}

		return new SimpleScope(tempList);
	}

}
