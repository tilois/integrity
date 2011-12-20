package de.gebit.integrity.experiments.fixtures;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import de.gebit.integrity.fixtures.ArbitraryParameterFixture;
import de.gebit.integrity.fixtures.FixtureMethod;
import de.gebit.integrity.fixtures.FixtureParameter;

public class ArbitraryParamFixture extends ArbitraryParameterFixture {

	@Override
	public List<ArbitraryParameterDefinition> defineArbitraryParameters(String aFixtureName,
			Map<String, Object> someFixedParameters, boolean aCalledInEclipseFlag) {
		List<ArbitraryParameterDefinition> tempList = new LinkedList<ArbitraryParameterFixture.ArbitraryParameterDefinition>();
		tempList.add(new ArbitraryParameterDefinition("testparam1", Integer.class, "This is the first parameter."));
		tempList.add(new ArbitraryParameterDefinition("testparam2", String.class, "This is the first parameter."));
		return tempList;
	}

	@FixtureMethod(description = "addition of $fixparam$ and $testparam1$")
	public Integer addition(@FixtureParameter(name = "fixparam") Integer aFixParam, Map<String, Object> someMoreParams) {
		return new Integer(aFixParam + (Integer) someMoreParams.get("testparam1"));
	}

}
