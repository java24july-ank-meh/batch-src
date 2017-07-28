package com.revature.design;

public class Factory {
	private Factory() {
		
	}
	
	public static Factory newInstance() {
		return new Factory(); //return a new object each time
	}
}