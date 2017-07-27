package com.revature.exception;

class NewException extends ArithmeticException {
	public String getMessage() {
		return "You can't do that";
	}
}

public class ExceptionDemo {
	
	public static String hello() {
		return "Hello";
	}
	
	public static int divide() {
		return 1/0;
	}

	public static void main(String[] args) {
		
		try {
			throwEx();
		} catch (NewException e) {
			System.out.println(e.getMessage());
		}		
		catch (Exception e) {
			System.out.println("Generic Exception thrown.");
		}

	}
	
	public static void throwEx() throws NewException {
		int x = 1/0;
	}

}
