package de.gebit.integrity.experiments.fixtures;

import java.util.Date;
import java.util.Map;

import de.gebit.integrity.fixtures.FixtureMethod;
import de.gebit.integrity.fixtures.FixtureParameter;

public class AdditionFixture {

	public static final String STRING_CONST = "Hello World!";

	public static final Integer INT_CONST = 123;

	public int integer = 123;

	/**
	 * Adds two integer numbers and returns the result.
	 * 
	 * @param aSummand1
	 *            the first number
	 * @param aSummand2
	 *            the second number
	 * @return the sum of both inputs
	 */
	@FixtureMethod(description = "addition of $summand1$ and $summand2$")
	public Integer addition(@FixtureParameter(name = "summand1") Integer aSummand1,
			@FixtureParameter(name = "summand2") Integer aSummand2) {
		pause();
		if (aSummand1 + aSummand2 == 50) {
			throw new RuntimeException("An exception!");
		}
		return new Integer(aSummand1 + aSummand2);
	}

	/**
	 * Creates a random number in a given interval.
	 * 
	 * @param aMin
	 *            the minimum
	 * @param aMax
	 *            the maximum
	 * @return a random number
	 */
	@FixtureMethod(description = "generates random number between $min$ and $max$")
	public Integer randomNumber(@FixtureParameter(name = "min") Integer aMin,
			@FixtureParameter(name = "max") Integer aMax) {
		pause();
		return new Integer((int) (Math.random() * (aMax - aMin) + aMin));
	}

	@FixtureMethod(description = "echoes $echo$")
	public Integer returnInteger(@FixtureParameter(name = "echo") Integer anInput) {
		pause();
		// throw new RuntimeException("An exception!");
		return anInput;
	}

	@FixtureMethod(description = "echoes $echo$")
	public String returnString(@FixtureParameter(name = "echo") String anInput) {
		pause();
		// throw new RuntimeException("An exception!");
		return anInput;
	}

	@FixtureMethod(description = "echoes $echo$")
	public Map<String, Object> returnValue(@FixtureParameter(name = "echo") Map<String, Object> anInput) {
		pause();
		// throw new RuntimeException("An exception!");
		return anInput;
	}

	@FixtureMethod(description = "echoes $echo$")
	public Date returnDate(@FixtureParameter(name = "echo") Date anInput) {
		pause();
		// throw new RuntimeException("An exception!");
		return anInput;
	}

	@FixtureMethod(description = "waits for $seconds$ seconds")
	public void wait(@FixtureParameter(name = "seconds") int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException exc) {
			// TODO Auto-generated catch block
			exc.printStackTrace();
		}
	}

	@FixtureMethod(description = "this test always succeeds :-)")
	public boolean returnTrue() {
		pause();
		return true;
	}

	@FixtureMethod(description = "this test always fails :-(")
	public boolean returnFalse() {
		pause();
		return false;
	}

	@FixtureMethod(description = "this test always returns null")
	public Object returnNull() {
		pause();
		return null;
	}

	@FixtureMethod(description = "this test always returns nulls")
	public String[] returnNullArray(@FixtureParameter(name = "entries") Integer aNumberOfNulls) {
		pause();
		return new String[aNumberOfNulls];
	}

	@FixtureMethod(description = "This always throws an exception. We're so doomed!")
	public boolean throwException() {
		System.out.println("Wow!");
		throw new RuntimeException("Holy shit!");
	}

	@FixtureMethod(description = "returns some named results")
	public NamedResultContainer multiResultFixture(@FixtureParameter(name = "param") String aParam) {
		return new NamedResultContainer(aParam, 100);
	}

	private void pause() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException exc) {
			exc.printStackTrace();
		}
	}

	public static class NamedResultContainer {

		private String firstNamedResult;

		private Integer secondNamedResult;

		public NamedResultContainer(String aFirstNamedResult, Integer aSecondNamedResult) {
			firstNamedResult = aFirstNamedResult;
			secondNamedResult = aSecondNamedResult;
		}

		public String getFirstNamedResult() {
			return firstNamedResult;
		}

		public Integer getSecondNamedResult() {
			return secondNamedResult;
		}

	}

}
