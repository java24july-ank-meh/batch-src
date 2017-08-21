package com.revature.cake;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {

	public static void main(String[] args) {
		//Load app context .xml
		ApplicationContext ctx = new ClassPathXmlApplicationContext("appContext.xml");
		//Fetch bean and load to cake object
		Bake cake = (Bake)ctx.getBean("poundCake");
		//Access business logic methods
		cake.getIngredients();
		cake.bakeCake();
	}

}
