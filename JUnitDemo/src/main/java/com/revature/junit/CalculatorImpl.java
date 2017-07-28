package com.revature.junit;

public class CalculatorImpl implements Calculator {

	@Override
	public int add(int x, int y) {
		return x + y;
	}

	@Override
	public int subtract(int x, int y) {
		return x - y;
	}

	@Override
	public int multiply(int x, int y) {
		return x * y;
	}

	@Override
	public int divide(int x, int y) {
		return x / y;
	}

	@Override
	public void exMethod() throws IllegalArgumentException {
		throw new IllegalArgumentException();

	}

	@Override
	public void timeMethod() {
		while (true) {
			
		}
	}

}
