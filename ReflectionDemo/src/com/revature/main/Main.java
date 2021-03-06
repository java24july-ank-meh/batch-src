package com.revature.main;

import java.lang.reflect.Field;

import com.revature.bean.Person;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException {
		Person bill = new Person();
		bill.setName("Bill");
		bill.setAge(30);
		bill.setSex('M');
		
		Class c = Class.forName("com.revature.bean.Person");
		Field[] fields = c.getDeclaredFields();
		for(Field f : fields) {
			System.out.println(f.getName());
		}
		
		Person joe = (Person) c.newInstance();
		joe.setName("Joe");
		System.out.println(joe.getName());
		
		Field age = c.getDeclaredField("age");
		age.setAccessible(true);
		age.set(bill, -800);
		System.out.println(bill.getAge());
	}

}
