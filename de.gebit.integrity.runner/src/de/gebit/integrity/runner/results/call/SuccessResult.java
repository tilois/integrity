package de.gebit.integrity.runner.results.call;

import de.gebit.integrity.dsl.VariableEntity;

public class SuccessResult extends CallResult {

	public SuccessResult(Object aResult, VariableEntity aTargetVariable, Long anExecutionTime) {
		super(aResult, aTargetVariable, anExecutionTime);
	}

}