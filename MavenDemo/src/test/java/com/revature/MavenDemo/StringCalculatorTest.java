package com.revature.MavenDemo;

import static org.junit.Assert.*;
import org.junit.Test;

public class StringCalculatorTest {
	
	@Test(expected = RuntimeException.class)
	public final void moreThanTwoThrowsException() {
		StringCalculator.add("1,2,3");
	}
	
	@Test
	public final void twoNumbersReturnsSum() {
		int sum = StringCalculator.add("1,2");
		assertEquals(3, sum);
	}
	
	@Test(expected = RuntimeException.class)
	public final void nonNumberInputThrowsException() {
		StringCalculator.add("hello");
	}
	
	@Test
	public final void zeroForEmptyString() {
		assertEquals(0, StringCalculator.add(""));
	}
	
	@Test
	public final void oneParameterReturnsItself() {
		assertEquals(4, StringCalculator.add("4"));
	}
	
	@Test
	public final void handlesWhitespace() {
		assertEquals(5, StringCalculator.add(" 2, 3 "));
	}

}





