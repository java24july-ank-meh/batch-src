package com.revature.array;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int arr [] = new int[5];
		int arr2[][] = new int[4][3];
		int[] arr3[] = new int[2][3];
		int[] arr4[], arr5[][];
		
		int[][] arr6 = {{1,2}, {3}, {4, 5, 6}};
		
		int[] numbers = { 6, 9, 3, 5, 1 };
		String[] strings = {"10", "9", "110"};
		
		Arrays.sort(numbers);
		for (int i= 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}
		System.out.println();
		
		Arrays.sort(strings);
		for (String s : strings) {
			System.out.print(s + " ");
		}
		System.out.println();
		
		System.out.println(Arrays.binarySearch(numbers, 9));
	}

}
