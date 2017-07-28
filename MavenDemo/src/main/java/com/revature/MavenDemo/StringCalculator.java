package com.revature.MavenDemo;

public class StringCalculator {
	public static void main(String[] args) {
	}
	/*
	 * Create a String calculator with method add(String numbers)
	 * Method can take 0, 1, or 2 numbers, and will return their sum
	 * returns 0 for empty string, return same number for 1 argument
	 * return sum of two numbers for two arguments
	 * removes whitespace
	 */
	public static int add(String numbers) {
		int sum = 0;
		numbers = numbers.replaceAll("\\s+", ""); //remove whitespaces
		String[] numbersArray = numbers.split(",");
		if (numbersArray.length > 2) {
			throw new RuntimeException("You're awful at this");
		} else {
			for (String number : numbersArray) {
				if (!number.equals("")) {
					sum += Integer.parseInt(number);
				} else {
					continue;
				}
			}
		}
		return sum;
		
	}

}
