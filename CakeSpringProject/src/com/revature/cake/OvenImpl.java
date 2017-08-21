package com.revature.cake;

import org.springframework.stereotype.Component;

@Component("oven")
public class OvenImpl implements IOven{

	@Override
	public void preheat() {
		System.out.println("Preheat oven...");
		
	}

	@Override
	public void insertCake() {
		System.out.println("Put cake in oven to start bake process");
	}

}
