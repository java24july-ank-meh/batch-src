package com.revature.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class CalculatorTest {
	@Test
	public void multiplicationOfZeroShouldReturnZero() {
		System.out.println("Currently testing x * 0");
		Calculator tester = new CalculatorImpl();
		assertEquals("10 * 0 should return 0", 0, tester.multiply(10, 0));
		assertEquals("0 * 10 should return 0", 0, tester.multiply(0, 10));
	}
	
	@Test
	public void additionShouldReturnSum() {
		System.out.println("Currently testing x + y = sum");
		Calculator tester = new CalculatorImpl();
		assertEquals("-4 + -2 should return -6", -6, tester.add(-4, -2));
	}
	
	@Before
	public void beforeMethod() {
		System.out.println("****Before each method****");
	}
	
	@After
	public void afterMethod() {
		System.out.println("****After each method****");
	}
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("----Before test class----");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("----After test class----");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void exMethodShouldThrowIAE() {
		System.out.println("Currently testing exMethod");
		Calculator tester = new CalculatorImpl();
		tester.exMethod();
		System.out.println("Right after exception call"); // doesn't get called because of exception
	}
	
	@Test(timeout = 3000)
	public void timeMethodShouldEndAfter3000() {
		System.out.println("Currently testing timeMethod");
		Calculator tester = new CalculatorImpl();
		tester.timeMethod();
	}
	
	@Ignore
	@Test
	public void ignoreTest() {
		System.out.println("Ignored");
	}
	
	@Ignore("Reason for being lazy")
	@Test
	public void ignoreWithMessage() {
		System.out.println("Ignored");
	}

}








