package com.revature.shapes;

public class Square extends Rectangle implements Shape {

	public Square() {
		super();
	}

	public Square(double height) {
		super(height, height);
	}
	
	public Square(double height, double width) {
		this(height);
	}

	@Override
	public String toString() {
		return "Square height = " + getHeight();
	}
	
}
