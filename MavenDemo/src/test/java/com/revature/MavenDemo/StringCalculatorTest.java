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

}
