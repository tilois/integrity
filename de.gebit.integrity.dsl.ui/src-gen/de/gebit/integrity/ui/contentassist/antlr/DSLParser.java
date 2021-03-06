/*
* generated by Xtext
*/
package de.gebit.integrity.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import de.gebit.integrity.services.DSLGrammarAccess;

public class DSLParser extends AbstractContentAssistParser {
	
	@Inject
	private DSLGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected de.gebit.integrity.ui.contentassist.antlr.internal.InternalDSLParser createParser() {
		de.gebit.integrity.ui.contentassist.antlr.internal.InternalDSLParser result = new de.gebit.integrity.ui.contentassist.antlr.internal.InternalDSLParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getStatementAccess().getAlternatives(), "rule__Statement__Alternatives");
					put(grammarAccess.getVisibleCommentAccess().getAlternatives(), "rule__VisibleComment__Alternatives");
					put(grammarAccess.getVisibleSingleLineCommentAccess().getAlternatives(), "rule__VisibleSingleLineComment__Alternatives");
					put(grammarAccess.getVisibleMultiLineCommentAccess().getAlternatives(), "rule__VisibleMultiLineComment__Alternatives");
					put(grammarAccess.getPackageStatementAccess().getAlternatives(), "rule__PackageStatement__Alternatives");
					put(grammarAccess.getSuiteStatementAccess().getAlternatives(), "rule__SuiteStatement__Alternatives");
					put(grammarAccess.getSuiteStatementWithResultAccess().getAlternatives(), "rule__SuiteStatementWithResult__Alternatives");
					put(grammarAccess.getConstantDefinitionAccess().getAlternatives_4(), "rule__ConstantDefinition__Alternatives_4");
					put(grammarAccess.getVariableOrConstantEntityAccess().getAlternatives(), "rule__VariableOrConstantEntity__Alternatives");
					put(grammarAccess.getResultNameAccess().getAlternatives(), "rule__ResultName__Alternatives");
					put(grammarAccess.getParameterNameAccess().getAlternatives(), "rule__ParameterName__Alternatives");
					put(grammarAccess.getOperationAccess().getAlternatives(), "rule__Operation__Alternatives");
					put(grammarAccess.getStandardOperationAccess().getOperatorsAlternatives_4_0_0(), "rule__StandardOperation__OperatorsAlternatives_4_0_0");
					put(grammarAccess.getValueOrEnumValueOrOperationAccess().getAlternatives(), "rule__ValueOrEnumValueOrOperation__Alternatives");
					put(grammarAccess.getValueAccess().getAlternatives(), "rule__Value__Alternatives");
					put(grammarAccess.getConstantValueAccess().getAlternatives(), "rule__ConstantValue__Alternatives");
					put(grammarAccess.getStaticValueAccess().getAlternatives(), "rule__StaticValue__Alternatives");
					put(grammarAccess.getBooleanValueAccess().getBooleanValueAlternatives_0(), "rule__BooleanValue__BooleanValueAlternatives_0");
					put(grammarAccess.getDateValueAccess().getAlternatives(), "rule__DateValue__Alternatives");
					put(grammarAccess.getTimeValueAccess().getAlternatives(), "rule__TimeValue__Alternatives");
					put(grammarAccess.getDateAndTimeValueAccess().getAlternatives(), "rule__DateAndTimeValue__Alternatives");
					put(grammarAccess.getModelAccess().getGroup(), "rule__Model__Group__0");
					put(grammarAccess.getVisibleSingleLineNormalCommentAccess().getGroup(), "rule__VisibleSingleLineNormalComment__Group__0");
					put(grammarAccess.getVisibleSingleLineTitleCommentAccess().getGroup(), "rule__VisibleSingleLineTitleComment__Group__0");
					put(grammarAccess.getVisibleMultiLineNormalCommentAccess().getGroup(), "rule__VisibleMultiLineNormalComment__Group__0");
					put(grammarAccess.getVisibleMultiLineTitleCommentAccess().getGroup(), "rule__VisibleMultiLineTitleComment__Group__0");
					put(grammarAccess.getVisibleDividerAccess().getGroup(), "rule__VisibleDivider__Group__0");
					put(grammarAccess.getPackageDefinitionAccess().getGroup(), "rule__PackageDefinition__Group__0");
					put(grammarAccess.getImportAccess().getGroup(), "rule__Import__Group__0");
					put(grammarAccess.getForkDefinitionAccess().getGroup(), "rule__ForkDefinition__Group__0");
					put(grammarAccess.getForkDefinitionAccess().getGroup_4(), "rule__ForkDefinition__Group_4__0");
					put(grammarAccess.getForkDefinitionAccess().getGroup_5(), "rule__ForkDefinition__Group_5__0");
					put(grammarAccess.getForkDefinitionAccess().getGroup_6(), "rule__ForkDefinition__Group_6__0");
					put(grammarAccess.getForkParameterAccess().getGroup(), "rule__ForkParameter__Group__0");
					put(grammarAccess.getVariantDefinitionAccess().getGroup(), "rule__VariantDefinition__Group__0");
					put(grammarAccess.getVariantDefinitionAccess().getGroup_4(), "rule__VariantDefinition__Group_4__0");
					put(grammarAccess.getTestDefinitionAccess().getGroup(), "rule__TestDefinition__Group__0");
					put(grammarAccess.getCallDefinitionAccess().getGroup(), "rule__CallDefinition__Group__0");
					put(grammarAccess.getSuiteDefinitionAccess().getGroup(), "rule__SuiteDefinition__Group__0");
					put(grammarAccess.getSuiteDefinitionAccess().getGroup_4(), "rule__SuiteDefinition__Group_4__0");
					put(grammarAccess.getSuiteDefinitionAccess().getGroup_4_2(), "rule__SuiteDefinition__Group_4_2__0");
					put(grammarAccess.getSuiteDefinitionAccess().getGroup_5(), "rule__SuiteDefinition__Group_5__0");
					put(grammarAccess.getSuiteDefinitionAccess().getGroup_5_2(), "rule__SuiteDefinition__Group_5_2__0");
					put(grammarAccess.getSuiteDefinitionAccess().getGroup_6(), "rule__SuiteDefinition__Group_6__0");
					put(grammarAccess.getSuiteDefinitionAccess().getGroup_6_2(), "rule__SuiteDefinition__Group_6_2__0");
					put(grammarAccess.getOperationDefinitionAccess().getGroup(), "rule__OperationDefinition__Group__0");
					put(grammarAccess.getVariableDefinitionAccess().getGroup(), "rule__VariableDefinition__Group__0");
					put(grammarAccess.getVariableDefinitionAccess().getGroup_4(), "rule__VariableDefinition__Group_4__0");
					put(grammarAccess.getConstantDefinitionAccess().getGroup(), "rule__ConstantDefinition__Group__0");
					put(grammarAccess.getConstantDefinitionAccess().getGroup_4_0(), "rule__ConstantDefinition__Group_4_0__0");
					put(grammarAccess.getConstantDefinitionAccess().getGroup_4_0_0(), "rule__ConstantDefinition__Group_4_0_0__0");
					put(grammarAccess.getConstantDefinitionAccess().getGroup_4_0_1(), "rule__ConstantDefinition__Group_4_0_1__0");
					put(grammarAccess.getConstantDefinitionAccess().getGroup_4_1(), "rule__ConstantDefinition__Group_4_1__0");
					put(grammarAccess.getVariantValueAccess().getGroup(), "rule__VariantValue__Group__0");
					put(grammarAccess.getVariantValueAccess().getGroup_2(), "rule__VariantValue__Group_2__0");
					put(grammarAccess.getTestAccess().getGroup(), "rule__Test__Group__0");
					put(grammarAccess.getTestAccess().getGroup_3(), "rule__Test__Group_3__0");
					put(grammarAccess.getTestAccess().getGroup_4(), "rule__Test__Group_4__0");
					put(grammarAccess.getTestAccess().getGroup_5(), "rule__Test__Group_5__0");
					put(grammarAccess.getTableTestAccess().getGroup(), "rule__TableTest__Group__0");
					put(grammarAccess.getTableTestAccess().getGroup_3(), "rule__TableTest__Group_3__0");
					put(grammarAccess.getTableTestAccess().getGroup_8(), "rule__TableTest__Group_8__0");
					put(grammarAccess.getTableTestAccess().getGroup_9(), "rule__TableTest__Group_9__0");
					put(grammarAccess.getTableTestRowAccess().getGroup(), "rule__TableTestRow__Group__0");
					put(grammarAccess.getParameterTableHeaderAccess().getGroup(), "rule__ParameterTableHeader__Group__0");
					put(grammarAccess.getResultTableHeaderAccess().getGroup(), "rule__ResultTableHeader__Group__0");
					put(grammarAccess.getParameterTableValueAccess().getGroup(), "rule__ParameterTableValue__Group__0");
					put(grammarAccess.getNamedResultAccess().getGroup(), "rule__NamedResult__Group__0");
					put(grammarAccess.getCallAccess().getGroup(), "rule__Call__Group__0");
					put(grammarAccess.getCallAccess().getGroup_2(), "rule__Call__Group_2__0");
					put(grammarAccess.getCallAccess().getGroup_4(), "rule__Call__Group_4__0");
					put(grammarAccess.getCallAccess().getGroup_5(), "rule__Call__Group_5__0");
					put(grammarAccess.getCallAccess().getGroup_6(), "rule__Call__Group_6__0");
					put(grammarAccess.getNamedCallResultAccess().getGroup(), "rule__NamedCallResult__Group__0");
					put(grammarAccess.getSuiteAccess().getGroup(), "rule__Suite__Group__0");
					put(grammarAccess.getSuiteAccess().getGroup_2(), "rule__Suite__Group_2__0");
					put(grammarAccess.getSuiteAccess().getGroup_5(), "rule__Suite__Group_5__0");
					put(grammarAccess.getSuiteAccess().getGroup_6(), "rule__Suite__Group_6__0");
					put(grammarAccess.getSuiteAccess().getGroup_7(), "rule__Suite__Group_7__0");
					put(grammarAccess.getSuiteAccess().getGroup_7_2(), "rule__Suite__Group_7_2__0");
					put(grammarAccess.getSuiteParameterAccess().getGroup(), "rule__SuiteParameter__Group__0");
					put(grammarAccess.getParameterAccess().getGroup(), "rule__Parameter__Group__0");
					put(grammarAccess.getArbitraryParameterOrResultNameAccess().getGroup(), "rule__ArbitraryParameterOrResultName__Group__0");
					put(grammarAccess.getStandardOperationAccess().getGroup(), "rule__StandardOperation__Group__0");
					put(grammarAccess.getStandardOperationAccess().getGroup_4(), "rule__StandardOperation__Group_4__0");
					put(grammarAccess.getCustomOperationAccess().getGroup(), "rule__CustomOperation__Group__0");
					put(grammarAccess.getCustomOperationAccess().getGroup_2(), "rule__CustomOperation__Group_2__0");
					put(grammarAccess.getCustomOperationAccess().getGroup_4(), "rule__CustomOperation__Group_4__0");
					put(grammarAccess.getValueOrEnumValueOrOperationCollectionAccess().getGroup(), "rule__ValueOrEnumValueOrOperationCollection__Group__0");
					put(grammarAccess.getValueOrEnumValueOrOperationCollectionAccess().getGroup_1(), "rule__ValueOrEnumValueOrOperationCollection__Group_1__0");
					put(grammarAccess.getIsoDateAndTimeValueAccess().getGroup(), "rule__IsoDateAndTimeValue__Group__0");
					put(grammarAccess.getEuropeanDateAnd24HrsTimeValueAccess().getGroup(), "rule__EuropeanDateAnd24HrsTimeValue__Group__0");
					put(grammarAccess.getEuropeanDateAnd12HrsTimeValueAccess().getGroup(), "rule__EuropeanDateAnd12HrsTimeValue__Group__0");
					put(grammarAccess.getUSDateAnd12HrsTimeValueAccess().getGroup(), "rule__USDateAnd12HrsTimeValue__Group__0");
					put(grammarAccess.getJavaConstantValueAccess().getGroup(), "rule__JavaConstantValue__Group__0");
					put(grammarAccess.getNullValueAccess().getGroup(), "rule__NullValue__Group__0");
					put(grammarAccess.getNestedObjectAccess().getGroup(), "rule__NestedObject__Group__0");
					put(grammarAccess.getNestedObjectAccess().getGroup_2(), "rule__NestedObject__Group_2__0");
					put(grammarAccess.getTypedNestedObjectAccess().getGroup(), "rule__TypedNestedObject__Group__0");
					put(grammarAccess.getKeyValuePairAccess().getGroup(), "rule__KeyValuePair__Group__0");
					put(grammarAccess.getMethodReferenceAccess().getGroup(), "rule__MethodReference__Group__0");
					put(grammarAccess.getJavaConstantReferenceAccess().getGroup(), "rule__JavaConstantReference__Group__0");
					put(grammarAccess.getExecutionMultiplierAccess().getGroup(), "rule__ExecutionMultiplier__Group__0");
					put(grammarAccess.getQualifiedNameAccess().getGroup(), "rule__QualifiedName__Group__0");
					put(grammarAccess.getQualifiedNameAccess().getGroup_1(), "rule__QualifiedName__Group_1__0");
					put(grammarAccess.getQualifiedJavaClassNameAccess().getGroup(), "rule__QualifiedJavaClassName__Group__0");
					put(grammarAccess.getQualifiedNameWithWildcardAccess().getGroup(), "rule__QualifiedNameWithWildcard__Group__0");
					put(grammarAccess.getNLAccess().getGroup(), "rule__NL__Group__0");
					put(grammarAccess.getNLFORCEDAccess().getGroup(), "rule__NLFORCED__Group__0");
					put(grammarAccess.getModelAccess().getStatementsAssignment_2(), "rule__Model__StatementsAssignment_2");
					put(grammarAccess.getVisibleSingleLineNormalCommentAccess().getContentAssignment_0(), "rule__VisibleSingleLineNormalComment__ContentAssignment_0");
					put(grammarAccess.getVisibleSingleLineTitleCommentAccess().getContentAssignment_0(), "rule__VisibleSingleLineTitleComment__ContentAssignment_0");
					put(grammarAccess.getVisibleMultiLineNormalCommentAccess().getContentAssignment_0(), "rule__VisibleMultiLineNormalComment__ContentAssignment_0");
					put(grammarAccess.getVisibleMultiLineTitleCommentAccess().getContentAssignment_0(), "rule__VisibleMultiLineTitleComment__ContentAssignment_0");
					put(grammarAccess.getVisibleDividerAccess().getContentAssignment_0(), "rule__VisibleDivider__ContentAssignment_0");
					put(grammarAccess.getPackageDefinitionAccess().getNameAssignment_2(), "rule__PackageDefinition__NameAssignment_2");
					put(grammarAccess.getPackageDefinitionAccess().getStatementsAssignment_5(), "rule__PackageDefinition__StatementsAssignment_5");
					put(grammarAccess.getImportAccess().getImportedNamespaceAssignment_2(), "rule__Import__ImportedNamespaceAssignment_2");
					put(grammarAccess.getForkDefinitionAccess().getNameAssignment_2(), "rule__ForkDefinition__NameAssignment_2");
					put(grammarAccess.getForkDefinitionAccess().getDescriptionAssignment_4_0(), "rule__ForkDefinition__DescriptionAssignment_4_0");
					put(grammarAccess.getForkDefinitionAccess().getForkerClassAssignment_5_2(), "rule__ForkDefinition__ForkerClassAssignment_5_2");
					put(grammarAccess.getForkDefinitionAccess().getParametersAssignment_6_0(), "rule__ForkDefinition__ParametersAssignment_6_0");
					put(grammarAccess.getForkParameterAccess().getNameAssignment_0(), "rule__ForkParameter__NameAssignment_0");
					put(grammarAccess.getForkParameterAccess().getValueAssignment_4(), "rule__ForkParameter__ValueAssignment_4");
					put(grammarAccess.getVariantDefinitionAccess().getNameAssignment_2(), "rule__VariantDefinition__NameAssignment_2");
					put(grammarAccess.getVariantDefinitionAccess().getDescriptionAssignment_4_0(), "rule__VariantDefinition__DescriptionAssignment_4_0");
					put(grammarAccess.getTestDefinitionAccess().getNameAssignment_2(), "rule__TestDefinition__NameAssignment_2");
					put(grammarAccess.getTestDefinitionAccess().getFixtureMethodAssignment_6(), "rule__TestDefinition__FixtureMethodAssignment_6");
					put(grammarAccess.getCallDefinitionAccess().getNameAssignment_2(), "rule__CallDefinition__NameAssignment_2");
					put(grammarAccess.getCallDefinitionAccess().getFixtureMethodAssignment_6(), "rule__CallDefinition__FixtureMethodAssignment_6");
					put(grammarAccess.getSuiteDefinitionAccess().getNameAssignment_2(), "rule__SuiteDefinition__NameAssignment_2");
					put(grammarAccess.getSuiteDefinitionAccess().getParametersAssignment_4_2_0(), "rule__SuiteDefinition__ParametersAssignment_4_2_0");
					put(grammarAccess.getSuiteDefinitionAccess().getDependenciesAssignment_5_2_0(), "rule__SuiteDefinition__DependenciesAssignment_5_2_0");
					put(grammarAccess.getSuiteDefinitionAccess().getFinalizersAssignment_6_2_0(), "rule__SuiteDefinition__FinalizersAssignment_6_2_0");
					put(grammarAccess.getSuiteDefinitionAccess().getStatementsAssignment_9(), "rule__SuiteDefinition__StatementsAssignment_9");
					put(grammarAccess.getOperationDefinitionAccess().getNameAssignment_2(), "rule__OperationDefinition__NameAssignment_2");
					put(grammarAccess.getOperationDefinitionAccess().getOperationTypeAssignment_6(), "rule__OperationDefinition__OperationTypeAssignment_6");
					put(grammarAccess.getVariableDefinitionAccess().getNameAssignment_2(), "rule__VariableDefinition__NameAssignment_2");
					put(grammarAccess.getVariableDefinitionAccess().getInitialValueAssignment_4_2(), "rule__VariableDefinition__InitialValueAssignment_4_2");
					put(grammarAccess.getConstantDefinitionAccess().getNameAssignment_2(), "rule__ConstantDefinition__NameAssignment_2");
					put(grammarAccess.getConstantDefinitionAccess().getValueAssignment_4_0_0_0(), "rule__ConstantDefinition__ValueAssignment_4_0_0_0");
					put(grammarAccess.getConstantDefinitionAccess().getVariantValuesAssignment_4_0_1_0(), "rule__ConstantDefinition__VariantValuesAssignment_4_0_1_0");
					put(grammarAccess.getConstantDefinitionAccess().getParameterizedAssignment_4_1_0(), "rule__ConstantDefinition__ParameterizedAssignment_4_1_0");
					put(grammarAccess.getVariantValueAccess().getNamesAssignment_2_0(), "rule__VariantValue__NamesAssignment_2_0");
					put(grammarAccess.getVariantValueAccess().getValueAssignment_5(), "rule__VariantValue__ValueAssignment_5");
					put(grammarAccess.getVariableEntityAccess().getNameAssignment(), "rule__VariableEntity__NameAssignment");
					put(grammarAccess.getConstantEntityAccess().getNameAssignment(), "rule__ConstantEntity__NameAssignment");
					put(grammarAccess.getTestAccess().getDefinitionAssignment_2(), "rule__Test__DefinitionAssignment_2");
					put(grammarAccess.getTestAccess().getParametersAssignment_3_1(), "rule__Test__ParametersAssignment_3_1");
					put(grammarAccess.getTestAccess().getResultsAssignment_4_1(), "rule__Test__ResultsAssignment_4_1");
					put(grammarAccess.getTestAccess().getResultAssignment_5_3(), "rule__Test__ResultAssignment_5_3");
					put(grammarAccess.getTableTestAccess().getDefinitionAssignment_2(), "rule__TableTest__DefinitionAssignment_2");
					put(grammarAccess.getTableTestAccess().getParametersAssignment_3_1(), "rule__TableTest__ParametersAssignment_3_1");
					put(grammarAccess.getTableTestAccess().getParameterHeadersAssignment_5(), "rule__TableTest__ParameterHeadersAssignment_5");
					put(grammarAccess.getTableTestAccess().getResultHeadersAssignment_6(), "rule__TableTest__ResultHeadersAssignment_6");
					put(grammarAccess.getTableTestAccess().getDefaultResultColumnAssignment_8_0(), "rule__TableTest__DefaultResultColumnAssignment_8_0");
					put(grammarAccess.getTableTestAccess().getRowsAssignment_9_1(), "rule__TableTest__RowsAssignment_9_1");
					put(grammarAccess.getTableTestRowAccess().getValuesAssignment_1(), "rule__TableTestRow__ValuesAssignment_1");
					put(grammarAccess.getParameterTableHeaderAccess().getNameAssignment_1(), "rule__ParameterTableHeader__NameAssignment_1");
					put(grammarAccess.getResultTableHeaderAccess().getNameAssignment_1(), "rule__ResultTableHeader__NameAssignment_1");
					put(grammarAccess.getParameterTableValueAccess().getValueAssignment_1(), "rule__ParameterTableValue__ValueAssignment_1");
					put(grammarAccess.getNamedResultAccess().getNameAssignment_0(), "rule__NamedResult__NameAssignment_0");
					put(grammarAccess.getNamedResultAccess().getValueAssignment_4(), "rule__NamedResult__ValueAssignment_4");
					put(grammarAccess.getFixedResultNameAccess().getFieldAssignment(), "rule__FixedResultName__FieldAssignment");
					put(grammarAccess.getCallAccess().getMultiplierAssignment_2_0(), "rule__Call__MultiplierAssignment_2_0");
					put(grammarAccess.getCallAccess().getDefinitionAssignment_3(), "rule__Call__DefinitionAssignment_3");
					put(grammarAccess.getCallAccess().getParametersAssignment_4_1(), "rule__Call__ParametersAssignment_4_1");
					put(grammarAccess.getCallAccess().getResultsAssignment_5_1(), "rule__Call__ResultsAssignment_5_1");
					put(grammarAccess.getCallAccess().getResultAssignment_6_3(), "rule__Call__ResultAssignment_6_3");
					put(grammarAccess.getNamedCallResultAccess().getNameAssignment_0(), "rule__NamedCallResult__NameAssignment_0");
					put(grammarAccess.getNamedCallResultAccess().getTargetAssignment_4(), "rule__NamedCallResult__TargetAssignment_4");
					put(grammarAccess.getSuiteAccess().getMultiplierAssignment_2_0(), "rule__Suite__MultiplierAssignment_2_0");
					put(grammarAccess.getSuiteAccess().getDefinitionAssignment_3(), "rule__Suite__DefinitionAssignment_3");
					put(grammarAccess.getSuiteAccess().getParametersAssignment_5_0(), "rule__Suite__ParametersAssignment_5_0");
					put(grammarAccess.getSuiteAccess().getForkAssignment_6_2(), "rule__Suite__ForkAssignment_6_2");
					put(grammarAccess.getSuiteAccess().getVariantsAssignment_7_2_0(), "rule__Suite__VariantsAssignment_7_2_0");
					put(grammarAccess.getSuiteParameterAccess().getNameAssignment_0(), "rule__SuiteParameter__NameAssignment_0");
					put(grammarAccess.getSuiteParameterAccess().getValueAssignment_4(), "rule__SuiteParameter__ValueAssignment_4");
					put(grammarAccess.getParameterAccess().getNameAssignment_0(), "rule__Parameter__NameAssignment_0");
					put(grammarAccess.getParameterAccess().getValueAssignment_4(), "rule__Parameter__ValueAssignment_4");
					put(grammarAccess.getFixedParameterNameAccess().getAnnotationAssignment(), "rule__FixedParameterName__AnnotationAssignment");
					put(grammarAccess.getArbitraryParameterOrResultNameAccess().getIdentifierAssignment_1(), "rule__ArbitraryParameterOrResultName__IdentifierAssignment_1");
					put(grammarAccess.getStandardOperationAccess().getFirstOperandAssignment_2(), "rule__StandardOperation__FirstOperandAssignment_2");
					put(grammarAccess.getStandardOperationAccess().getOperatorsAssignment_4_0(), "rule__StandardOperation__OperatorsAssignment_4_0");
					put(grammarAccess.getStandardOperationAccess().getMoreOperandsAssignment_4_2(), "rule__StandardOperation__MoreOperandsAssignment_4_2");
					put(grammarAccess.getCustomOperationAccess().getPrefixOperandAssignment_2_0(), "rule__CustomOperation__PrefixOperandAssignment_2_0");
					put(grammarAccess.getCustomOperationAccess().getDefinitionAssignment_3(), "rule__CustomOperation__DefinitionAssignment_3");
					put(grammarAccess.getCustomOperationAccess().getPostfixOperandAssignment_4_2(), "rule__CustomOperation__PostfixOperandAssignment_4_2");
					put(grammarAccess.getValueOrEnumValueOrOperationCollectionAccess().getValueAssignment_0(), "rule__ValueOrEnumValueOrOperationCollection__ValueAssignment_0");
					put(grammarAccess.getValueOrEnumValueOrOperationCollectionAccess().getMoreValuesAssignment_1_3(), "rule__ValueOrEnumValueOrOperationCollection__MoreValuesAssignment_1_3");
					put(grammarAccess.getIntegerValueAccess().getIntegerValueAssignment(), "rule__IntegerValue__IntegerValueAssignment");
					put(grammarAccess.getDecimalValueAccess().getDecimalValueAssignment(), "rule__DecimalValue__DecimalValueAssignment");
					put(grammarAccess.getStringValueAccess().getStringValueAssignment(), "rule__StringValue__StringValueAssignment");
					put(grammarAccess.getBooleanValueAccess().getBooleanValueAssignment(), "rule__BooleanValue__BooleanValueAssignment");
					put(grammarAccess.getIsoDateValueAccess().getDateValueAssignment(), "rule__IsoDateValue__DateValueAssignment");
					put(grammarAccess.getEuropeanDateValueAccess().getDateValueAssignment(), "rule__EuropeanDateValue__DateValueAssignment");
					put(grammarAccess.getUSDateValueAccess().getDateValueAssignment(), "rule__USDateValue__DateValueAssignment");
					put(grammarAccess.getIsoTimeValueAccess().getTimeValueAssignment(), "rule__IsoTimeValue__TimeValueAssignment");
					put(grammarAccess.getSimple24HrsTimeValueAccess().getTimeValueAssignment(), "rule__Simple24HrsTimeValue__TimeValueAssignment");
					put(grammarAccess.getSimple12HrsTimeValueAccess().getTimeValueAssignment(), "rule__Simple12HrsTimeValue__TimeValueAssignment");
					put(grammarAccess.getIsoDateAndTimeValueAccess().getDateValueAssignment_0(), "rule__IsoDateAndTimeValue__DateValueAssignment_0");
					put(grammarAccess.getIsoDateAndTimeValueAccess().getTimeValueAssignment_1(), "rule__IsoDateAndTimeValue__TimeValueAssignment_1");
					put(grammarAccess.getEuropeanDateAnd24HrsTimeValueAccess().getDateValueAssignment_0(), "rule__EuropeanDateAnd24HrsTimeValue__DateValueAssignment_0");
					put(grammarAccess.getEuropeanDateAnd24HrsTimeValueAccess().getTimeValueAssignment_2(), "rule__EuropeanDateAnd24HrsTimeValue__TimeValueAssignment_2");
					put(grammarAccess.getEuropeanDateAnd12HrsTimeValueAccess().getDateValueAssignment_0(), "rule__EuropeanDateAnd12HrsTimeValue__DateValueAssignment_0");
					put(grammarAccess.getEuropeanDateAnd12HrsTimeValueAccess().getTimeValueAssignment_2(), "rule__EuropeanDateAnd12HrsTimeValue__TimeValueAssignment_2");
					put(grammarAccess.getUSDateAnd12HrsTimeValueAccess().getDateValueAssignment_0(), "rule__USDateAnd12HrsTimeValue__DateValueAssignment_0");
					put(grammarAccess.getUSDateAnd12HrsTimeValueAccess().getTimeValueAssignment_2(), "rule__USDateAnd12HrsTimeValue__TimeValueAssignment_2");
					put(grammarAccess.getJavaConstantValueAccess().getConstantAssignment_1(), "rule__JavaConstantValue__ConstantAssignment_1");
					put(grammarAccess.getVariableAccess().getNameAssignment(), "rule__Variable__NameAssignment");
					put(grammarAccess.getVariableVariableAccess().getNameAssignment(), "rule__VariableVariable__NameAssignment");
					put(grammarAccess.getConstantAccess().getNameAssignment(), "rule__Constant__NameAssignment");
					put(grammarAccess.getEnumValueAccess().getEnumValueAssignment(), "rule__EnumValue__EnumValueAssignment");
					put(grammarAccess.getNestedObjectAccess().getAttributesAssignment_2_0(), "rule__NestedObject__AttributesAssignment_2_0");
					put(grammarAccess.getTypedNestedObjectAccess().getTypeAssignment_1(), "rule__TypedNestedObject__TypeAssignment_1");
					put(grammarAccess.getTypedNestedObjectAccess().getNestedObjectAssignment_4(), "rule__TypedNestedObject__NestedObjectAssignment_4");
					put(grammarAccess.getKeyValuePairAccess().getIdentifierAssignment_0(), "rule__KeyValuePair__IdentifierAssignment_0");
					put(grammarAccess.getKeyValuePairAccess().getValueAssignment_4(), "rule__KeyValuePair__ValueAssignment_4");
					put(grammarAccess.getJavaClassReferenceAccess().getTypeAssignment(), "rule__JavaClassReference__TypeAssignment");
					put(grammarAccess.getMethodReferenceAccess().getTypeAssignment_0(), "rule__MethodReference__TypeAssignment_0");
					put(grammarAccess.getMethodReferenceAccess().getMethodAssignment_2(), "rule__MethodReference__MethodAssignment_2");
					put(grammarAccess.getJavaConstantReferenceAccess().getTypeAssignment_0(), "rule__JavaConstantReference__TypeAssignment_0");
					put(grammarAccess.getJavaConstantReferenceAccess().getConstantAssignment_2(), "rule__JavaConstantReference__ConstantAssignment_2");
					put(grammarAccess.getExecutionMultiplierAccess().getCountAssignment_0(), "rule__ExecutionMultiplier__CountAssignment_0");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			de.gebit.integrity.ui.contentassist.antlr.internal.InternalDSLParser typedParser = (de.gebit.integrity.ui.contentassist.antlr.internal.InternalDSLParser) parser;
			typedParser.entryRuleModel();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}
	
	public DSLGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(DSLGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
