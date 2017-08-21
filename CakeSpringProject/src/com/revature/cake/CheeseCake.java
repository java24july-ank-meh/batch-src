package com.revature.cake;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CheeseCake implements Bake {

	@Autowired
	IOven oven;
	
	@Override
	public void getIngredients() {
		System.out.println("Ingredients for Cheese cake: Cheese, Eggs, Milk, Flour, Sugar, Graham Cracker");
		
	}

	@Override
	public void bakeCake() {
		oven.preheat();
		oven.insertCake();
		System.out.println("Bake for 45 mins at 300 degrees");
	}

}
