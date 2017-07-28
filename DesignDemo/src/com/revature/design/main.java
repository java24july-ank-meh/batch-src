package com.revature.design;

public class main {

	public static void main(String[] args) {
		Singleton s = Singleton.getSingletonObject();
		Singleton s2 = Singleton.getSingletonObject();
		
		System.out.println(s);
		System.out.println(s2);

	}

}
