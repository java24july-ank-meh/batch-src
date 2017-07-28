package com.revature.design;

public class Singleton {
	
	private static Singleton object;
	private static Object lock = new Object();
	
	private Singleton() {
		// something complex
	}
	
	public static Singleton getSingletonObject() {
		synchronized(lock) {
			if (object == null) {
				//code here
				object = new Singleton();
			}
		}
		
		return object;
	}

}
