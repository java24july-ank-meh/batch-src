package com.revature.StringDemo;

public class SBDemo {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		for (char current = 'a'; current <= 'z'; current++) {
			sb.append(current);
		}
		System.out.println(sb);
	}

}
