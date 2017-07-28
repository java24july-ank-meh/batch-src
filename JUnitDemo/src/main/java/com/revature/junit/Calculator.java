package com.revature.junit;

public interface Calculator {
	public int add(int x, int y);
	public int subtract(int x, int y);
	public int multiply(int x, int y);
	public int divide(int x, int y);
	
	public void exMethod() throws IllegalArgumentException;
	public void timeMethod();

}
