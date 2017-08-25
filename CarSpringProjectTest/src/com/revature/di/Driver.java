package com.revature.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {

	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("appContext.xml");
		Vehicle vehicle = (Vehicle)ctx.getBean("car");
		vehicle.drive();
		vehicle.stop();
		Vehicle vehicle1 = (Vehicle)ctx.getBean("bike");
		vehicle1.drive();
		vehicle1.stop();
	}
}
