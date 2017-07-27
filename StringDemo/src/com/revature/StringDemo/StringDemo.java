package com.revature.StringDemo;

import java.util.Arrays;

public class StringDemo {

	public static void main(String[] args) {
		String str1 = "Hello World";
		String str2 = new String("HELLO WORLD");
		
		/*
		if (str1.equalsIgnoreCase(str2)) {
			System.out.println("Equals");
		} else {
			System.out.println("Not Equals");
		}
		*/
		
		char[] helloArray = {'h', 'e', 'l', 'l', 'o'};
		String helloString = new String(helloArray);
		System.out.println(helloString);
		
		//indexOf
		String str3 = "The quick brown fox jumps over the lazy dog";
		System.out.println(str3.indexOf('k'));
		str3 = "";
		str3 = null;
		
		//isEmpty
		//System.out.println(str3.isEmpty());
		
		//format
		String s = "hello";
		s = String.format("%s world",  s);
		System.out.println(s);
		
		//split
		String s2 = "hello world everyone";
		String s3 = "hello,world,everyone";
		String[] returned = s2.split(" ");
		returned = s3.split(",");
		System.out.println(Arrays.toString(returned));
		System.out.println(returned[0]);
		
		String s4 = "aloha";
		char[] arr = new char[5];
		s4.getChars(0, 4, arr, 1);
		System.out.println(arr);
		
		//replace
		String s5 = "hola";
		String s6 = s5.replace('o', 'u');
		System.out.println(s6);
		
		//StringBuffer
		StringBuffer sb = new StringBuffer("doom");
		sb.reverse();
		System.out.println(sb);
		
		varargMethod(0, 0, returned);
		
		

	}
	
	public static void varargMethod(int x, int y, String... strings) {
		System.out.println(strings.toString());
	}
	
	//1) Reverse a string without using a temporary variable. Do NOT use reverse()
	//2) Write a substring method that accepts a string str and in integer idx
	//   and returns the substring contained between 0 and idx-1 inclusive. Do NOT
	//   use any existing substring methods in String, ...
	

}
