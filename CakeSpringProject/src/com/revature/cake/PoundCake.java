package com.revature.cake;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class PoundCake implements Bake{

	@Autowired
	IOven oven;
	
	@Override
	public void getIngredients() {
		System.out.println("Ingredients for Pound cake: Eggs, Flour, Milk, nutmeg");
	}

	@Override
	public void bakeCake() {
		oven.preheat();
		oven.insertCake();
		System.out.println("Bake for 1 hour at 350 degrees");
	}

}
