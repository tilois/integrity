package de.gebit.integrity.experiments.fixtures;

import de.gebit.integrity.fixtures.FixtureMethod;
import de.gebit.integrity.fixtures.FixtureParameter;

public class BeanFixture {

	@FixtureMethod(description = "inputs $bean$")
	public void beanInput(@FixtureParameter(name = "bean") TestBean aBean) {
		System.out.println(aBean);
	}

}
