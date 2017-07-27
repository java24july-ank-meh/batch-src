package com.revature.main;

import com.revature.shapes.*;

public class Main {

	public static void main(String[] args) {
		Circle c = new Circle(5);
		System.out.println(c.calculateArea());
		
		Ellipse e = new Circle(5);
		System.out.println(e.calculateArea());
		
		Shape s = new Circle(5);
		System.out.println(s.calculateArea());
		
		Rectangle r = new Rectangle(3, 4);
		System.out.println(r.calculateArea());
		System.out.println(r.perimeter());
		System.out.println(r.perimeter(5, 5));
		r.perimeter(5);
		
		/*Shape s2 = new Rectangle(3, 4);
		System.out.println(s2.calculateArea());
		
		Square sq = new Square(4);
		System.out.println(sq.calculateArea());*/
	}

}
