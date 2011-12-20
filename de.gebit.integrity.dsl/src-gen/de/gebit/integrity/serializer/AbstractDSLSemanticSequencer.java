package de.gebit.integrity.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import de.gebit.integrity.dsl.ArbitraryParameterName;
import de.gebit.integrity.dsl.ArbitraryTestResultName;
import de.gebit.integrity.dsl.Call;
import de.gebit.integrity.dsl.CallDefinition;
import de.gebit.integrity.dsl.DecimalValue;
import de.gebit.integrity.dsl.DslPackage;
import de.gebit.integrity.dsl.EnumValue;
import de.gebit.integrity.dsl.FixedParameterName;
import de.gebit.integrity.dsl.FixedTestResultName;
import de.gebit.integrity.dsl.Import;
import de.gebit.integrity.dsl.IntegerValue;
import de.gebit.integrity.dsl.MethodReference;
import de.gebit.integrity.dsl.Model;
import de.gebit.integrity.dsl.NamedTestResult;
import de.gebit.integrity.dsl.PackageDefinition;
import de.gebit.integrity.dsl.Parameter;
import de.gebit.integrity.dsl.ParameterTableHeader;
import de.gebit.integrity.dsl.ParameterTableValue;
import de.gebit.integrity.dsl.StringValue;
import de.gebit.integrity.dsl.Suite;
import de.gebit.integrity.dsl.SuiteDefinition;
import de.gebit.integrity.dsl.SuiteParameter;
import de.gebit.integrity.dsl.TableTest;
import de.gebit.integrity.dsl.TableTestRow;
import de.gebit.integrity.dsl.Test;
import de.gebit.integrity.dsl.TestDefinition;
import de.gebit.integrity.dsl.Variable;
import de.gebit.integrity.dsl.VariableDefinition;
import de.gebit.integrity.dsl.VariableEntity;
import de.gebit.integrity.services.DSLGrammarAccess;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("restriction")
public class AbstractDSLSemanticSequencer extends AbstractSemanticSequencer {

	@Inject
	protected DSLGrammarAccess grammarAccess;
	
	@Inject
	protected ISemanticSequencerDiagnosticProvider diagnosticProvider;
	
	@Inject
	protected ITransientValueService transientValues;
	
	@Inject
	@GenericSequencer
	protected Provider<ISemanticSequencer> genericSequencerProvider;
	
	protected ISemanticSequencer genericSequencer;
	
	
	@Override
	public void init(ISemanticSequencer sequencer, ISemanticSequenceAcceptor sequenceAcceptor, Acceptor errorAcceptor) {
		super.init(sequencer, sequenceAcceptor, errorAcceptor);
		this.genericSequencer = genericSequencerProvider.get();
		this.genericSequencer.init(sequencer, sequenceAcceptor, errorAcceptor);
	}
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == DslPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case DslPackage.ARBITRARY_PARAMETER_NAME:
				if(context == grammarAccess.getArbitraryParameterNameRule() ||
				   context == grammarAccess.getParameterNameRule()) {
					sequence_ArbitraryParameterName(context, (ArbitraryParameterName) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.ARBITRARY_TEST_RESULT_NAME:
				if(context == grammarAccess.getArbitraryTestResultNameRule() ||
				   context == grammarAccess.getTestResultNameRule()) {
					sequence_ArbitraryTestResultName(context, (ArbitraryTestResultName) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.CALL:
				if(context == grammarAccess.getCallRule() ||
				   context == grammarAccess.getSuiteStatementRule()) {
					sequence_Call(context, (Call) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.CALL_DEFINITION:
				if(context == grammarAccess.getCallDefinitionRule() ||
				   context == grammarAccess.getPackageStatementRule()) {
					sequence_CallDefinition(context, (CallDefinition) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.DECIMAL_VALUE:
				if(context == grammarAccess.getDecimalValueRule() ||
				   context == grammarAccess.getValueRule() ||
				   context == grammarAccess.getValueOrEnumValueRule()) {
					sequence_DecimalValue(context, (DecimalValue) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.ENUM_VALUE:
				if(context == grammarAccess.getEnumValueRule() ||
				   context == grammarAccess.getValueOrEnumValueRule()) {
					sequence_EnumValue(context, (EnumValue) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.FIXED_PARAMETER_NAME:
				if(context == grammarAccess.getFixedParameterNameRule() ||
				   context == grammarAccess.getParameterNameRule()) {
					sequence_FixedParameterName(context, (FixedParameterName) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.FIXED_TEST_RESULT_NAME:
				if(context == grammarAccess.getFixedTestResultNameRule() ||
				   context == grammarAccess.getTestResultNameRule()) {
					sequence_FixedTestResultName(context, (FixedTestResultName) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.IMPORT:
				if(context == grammarAccess.getImportRule() ||
				   context == grammarAccess.getPackageStatementRule() ||
				   context == grammarAccess.getStatementRule()) {
					sequence_Import(context, (Import) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.INTEGER_VALUE:
				if(context == grammarAccess.getIntegerValueRule() ||
				   context == grammarAccess.getValueRule() ||
				   context == grammarAccess.getValueOrEnumValueRule()) {
					sequence_IntegerValue(context, (IntegerValue) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.METHOD_REFERENCE:
				if(context == grammarAccess.getMethodReferenceRule()) {
					sequence_MethodReference(context, (MethodReference) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.MODEL:
				if(context == grammarAccess.getModelRule()) {
					sequence_Model(context, (Model) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.NAMED_TEST_RESULT:
				if(context == grammarAccess.getNamedTestResultRule()) {
					sequence_NamedTestResult(context, (NamedTestResult) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.PACKAGE_DEFINITION:
				if(context == grammarAccess.getPackageDefinitionRule() ||
				   context == grammarAccess.getStatementRule()) {
					sequence_PackageDefinition(context, (PackageDefinition) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.PARAMETER:
				if(context == grammarAccess.getParameterRule()) {
					sequence_Parameter(context, (Parameter) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.PARAMETER_TABLE_HEADER:
				if(context == grammarAccess.getParameterTableHeaderRule()) {
					sequence_ParameterTableHeader(context, (ParameterTableHeader) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.PARAMETER_TABLE_VALUE:
				if(context == grammarAccess.getParameterTableValueRule()) {
					sequence_ParameterTableValue(context, (ParameterTableValue) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.STRING_VALUE:
				if(context == grammarAccess.getStringValueRule() ||
				   context == grammarAccess.getValueRule() ||
				   context == grammarAccess.getValueOrEnumValueRule()) {
					sequence_StringValue(context, (StringValue) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.SUITE:
				if(context == grammarAccess.getStatementRule() ||
				   context == grammarAccess.getSuiteRule() ||
				   context == grammarAccess.getSuiteStatementRule() ||
				   context == grammarAccess.getSuiteStatementWithResultRule()) {
					sequence_Suite(context, (Suite) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.SUITE_DEFINITION:
				if(context == grammarAccess.getPackageStatementRule() ||
				   context == grammarAccess.getSuiteDefinitionRule()) {
					sequence_SuiteDefinition(context, (SuiteDefinition) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.SUITE_PARAMETER:
				if(context == grammarAccess.getSuiteParameterRule()) {
					sequence_SuiteParameter(context, (SuiteParameter) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.TABLE_TEST:
				if(context == grammarAccess.getSuiteStatementRule() ||
				   context == grammarAccess.getSuiteStatementWithResultRule() ||
				   context == grammarAccess.getTableTestRule()) {
					sequence_TableTest(context, (TableTest) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.TABLE_TEST_ROW:
				if(context == grammarAccess.getTableTestRowRule()) {
					sequence_TableTestRow(context, (TableTestRow) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.TEST:
				if(context == grammarAccess.getSuiteStatementRule() ||
				   context == grammarAccess.getSuiteStatementWithResultRule() ||
				   context == grammarAccess.getTestRule()) {
					sequence_Test(context, (Test) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.TEST_DEFINITION:
				if(context == grammarAccess.getPackageStatementRule() ||
				   context == grammarAccess.getTestDefinitionRule()) {
					sequence_TestDefinition(context, (TestDefinition) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.VARIABLE:
				if(context == grammarAccess.getValueRule() ||
				   context == grammarAccess.getValueOrEnumValueRule() ||
				   context == grammarAccess.getVariableRule()) {
					sequence_Variable(context, (Variable) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.VARIABLE_DEFINITION:
				if(context == grammarAccess.getPackageStatementRule() ||
				   context == grammarAccess.getSuiteStatementRule() ||
				   context == grammarAccess.getVariableDefinitionRule()) {
					sequence_VariableDefinition(context, (VariableDefinition) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.VARIABLE_ENTITY:
				if(context == grammarAccess.getVariableEntityRule()) {
					sequence_VariableEntity(context, (VariableEntity) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     identifier=ID
	 */
	protected void sequence_ArbitraryParameterName(EObject context, ArbitraryParameterName semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.ARBITRARY_PARAMETER_NAME__IDENTIFIER) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.ARBITRARY_PARAMETER_NAME__IDENTIFIER));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getArbitraryParameterNameAccess().getIdentifierIDTerminalRuleCall_1_0(), semanticObject.getIdentifier());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     identifier=ID
	 */
	protected void sequence_ArbitraryTestResultName(EObject context, ArbitraryTestResultName semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.ARBITRARY_TEST_RESULT_NAME__IDENTIFIER) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.ARBITRARY_TEST_RESULT_NAME__IDENTIFIER));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getArbitraryTestResultNameAccess().getIdentifierIDTerminalRuleCall_1_0(), semanticObject.getIdentifier());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=QualifiedName fixtureMethod=MethodReference)
	 */
	protected void sequence_CallDefinition(EObject context, CallDefinition semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.CALL_DEFINITION__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.CALL_DEFINITION__NAME));
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.CALL_DEFINITION__FIXTURE_METHOD) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.CALL_DEFINITION__FIXTURE_METHOD));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getCallDefinitionAccess().getNameQualifiedNameParserRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getCallDefinitionAccess().getFixtureMethodMethodReferenceParserRuleCall_3_0(), semanticObject.getFixtureMethod());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (definition=[CallDefinition|QualifiedName] parameters+=Parameter* result=Variable?)
	 */
	protected void sequence_Call(EObject context, Call semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     decimalValue=DECIMAL
	 */
	protected void sequence_DecimalValue(EObject context, DecimalValue semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.DECIMAL_VALUE__DECIMAL_VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.DECIMAL_VALUE__DECIMAL_VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getDecimalValueAccess().getDecimalValueDECIMALTerminalRuleCall_0(), semanticObject.getDecimalValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     enumValue=[JvmEnumerationLiteral|UPPERCASE_ID]
	 */
	protected void sequence_EnumValue(EObject context, EnumValue semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.ENUM_VALUE__ENUM_VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.ENUM_VALUE__ENUM_VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getEnumValueAccess().getEnumValueJvmEnumerationLiteralUPPERCASE_IDTerminalRuleCall_0_1(), semanticObject.getEnumValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     annotation=[JvmAnnotationReference|ID]
	 */
	protected void sequence_FixedParameterName(EObject context, FixedParameterName semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.FIXED_PARAMETER_NAME__ANNOTATION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.FIXED_PARAMETER_NAME__ANNOTATION));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getFixedParameterNameAccess().getAnnotationJvmAnnotationReferenceIDTerminalRuleCall_0_1(), semanticObject.getAnnotation());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     field=[JvmField|ID]
	 */
	protected void sequence_FixedTestResultName(EObject context, FixedTestResultName semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.FIXED_TEST_RESULT_NAME__FIELD) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.FIXED_TEST_RESULT_NAME__FIELD));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getFixedTestResultNameAccess().getFieldJvmFieldIDTerminalRuleCall_0_1(), semanticObject.getField());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     importedNamespace=QualifiedNameWithWildcard
	 */
	protected void sequence_Import(EObject context, Import semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.IMPORT__IMPORTED_NAMESPACE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.IMPORT__IMPORTED_NAMESPACE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_0(), semanticObject.getImportedNamespace());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     integerValue=INTEGER
	 */
	protected void sequence_IntegerValue(EObject context, IntegerValue semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.INTEGER_VALUE__INTEGER_VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.INTEGER_VALUE__INTEGER_VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getIntegerValueAccess().getIntegerValueINTEGERTerminalRuleCall_0(), semanticObject.getIntegerValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (type=[JvmType|QualifiedJavaClassName] method=[JvmOperation|ID])
	 */
	protected void sequence_MethodReference(EObject context, MethodReference semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.METHOD_REFERENCE__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.METHOD_REFERENCE__TYPE));
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.METHOD_REFERENCE__METHOD) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.METHOD_REFERENCE__METHOD));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getMethodReferenceAccess().getTypeJvmTypeQualifiedJavaClassNameParserRuleCall_0_0_1(), semanticObject.getType());
		feeder.accept(grammarAccess.getMethodReferenceAccess().getMethodJvmOperationIDTerminalRuleCall_2_0_1(), semanticObject.getMethod());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     statements+=Statement*
	 */
	protected void sequence_Model(EObject context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=TestResultName value=ValueOrEnumValue)
	 */
	protected void sequence_NamedTestResult(EObject context, NamedTestResult semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.NAMED_TEST_RESULT__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.NAMED_TEST_RESULT__NAME));
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.NAMED_TEST_RESULT__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.NAMED_TEST_RESULT__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getNamedTestResultAccess().getNameTestResultNameParserRuleCall_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getNamedTestResultAccess().getValueValueOrEnumValueParserRuleCall_2_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=QualifiedName statements+=PackageStatement*)
	 */
	protected void sequence_PackageDefinition(EObject context, PackageDefinition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=ParameterName
	 */
	protected void sequence_ParameterTableHeader(EObject context, ParameterTableHeader semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.PARAMETER_TABLE_HEADER__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.PARAMETER_TABLE_HEADER__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getParameterTableHeaderAccess().getNameParameterNameParserRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     value=ValueOrEnumValue
	 */
	protected void sequence_ParameterTableValue(EObject context, ParameterTableValue semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.PARAMETER_TABLE_VALUE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.PARAMETER_TABLE_VALUE__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getParameterTableValueAccess().getValueValueOrEnumValueParserRuleCall_1_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=ParameterName value=ValueOrEnumValue)
	 */
	protected void sequence_Parameter(EObject context, Parameter semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.PARAMETER__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.PARAMETER__NAME));
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.PARAMETER__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.PARAMETER__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getParameterAccess().getNameParameterNameParserRuleCall_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getParameterAccess().getValueValueOrEnumValueParserRuleCall_2_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     stringValue=STRING
	 */
	protected void sequence_StringValue(EObject context, StringValue semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.STRING_VALUE__STRING_VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.STRING_VALUE__STRING_VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getStringValueAccess().getStringValueSTRINGTerminalRuleCall_0(), semanticObject.getStringValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=QualifiedName 
	 *         parameters+=VariableEntity* 
	 *         dependencies+=[SuiteDefinition|QualifiedName]* 
	 *         statements+=SuiteStatement* 
	 *         finalizers+=[SuiteDefinition|QualifiedName]*
	 *     )
	 */
	protected void sequence_SuiteDefinition(EObject context, SuiteDefinition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=[VariableEntity|QualifiedName] value=Value)
	 */
	protected void sequence_SuiteParameter(EObject context, SuiteParameter semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.SUITE_PARAMETER__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.SUITE_PARAMETER__NAME));
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.SUITE_PARAMETER__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.SUITE_PARAMETER__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSuiteParameterAccess().getNameVariableEntityQualifiedNameParserRuleCall_0_0_1(), semanticObject.getName());
		feeder.accept(grammarAccess.getSuiteParameterAccess().getValueValueParserRuleCall_2_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (definition=[SuiteDefinition|QualifiedName] parameters+=SuiteParameter*)
	 */
	protected void sequence_Suite(EObject context, Suite semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (values+=ParameterTableValue* result=ValueOrEnumValue?)
	 */
	protected void sequence_TableTestRow(EObject context, TableTestRow semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (definition=[TestDefinition|QualifiedName] parameters+=Parameter* headers+=ParameterTableHeader+ rows+=TableTestRow+)
	 */
	protected void sequence_TableTest(EObject context, TableTest semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=QualifiedName fixtureMethod=MethodReference)
	 */
	protected void sequence_TestDefinition(EObject context, TestDefinition semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.TEST_DEFINITION__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.TEST_DEFINITION__NAME));
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.TEST_DEFINITION__FIXTURE_METHOD) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.TEST_DEFINITION__FIXTURE_METHOD));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getTestDefinitionAccess().getNameQualifiedNameParserRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getTestDefinitionAccess().getFixtureMethodMethodReferenceParserRuleCall_3_0(), semanticObject.getFixtureMethod());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (definition=[TestDefinition|QualifiedName] parameters+=Parameter* results+=NamedTestResult* result=ValueOrEnumValue?)
	 */
	protected void sequence_Test(EObject context, Test semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=VariableEntity initialValue=Value?)
	 */
	protected void sequence_VariableDefinition(EObject context, VariableDefinition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=QualifiedName
	 */
	protected void sequence_VariableEntity(EObject context, VariableEntity semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.VARIABLE_ENTITY__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.VARIABLE_ENTITY__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getVariableEntityAccess().getNameQualifiedNameParserRuleCall_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     name=[VariableEntity|QualifiedName]
	 */
	protected void sequence_Variable(EObject context, Variable semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.VARIABLE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.VARIABLE__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getVariableAccess().getNameVariableEntityQualifiedNameParserRuleCall_0_1(), semanticObject.getName());
		feeder.finish();
	}
}