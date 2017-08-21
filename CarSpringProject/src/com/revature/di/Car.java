package com.revature.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car implements Vehicle {

	@Autowired
	Honda carName;
	
	/*public void setCarName(Honda carName) {
		this.carName = carName;
	}*/

	@Override
	public void drive() {
		carName.getNameOfCar();
		System.out.println(" driving");
	}

	@Override
	public void stop() {
		carName.getNameOfCar();
		System.out.println(" stopping");
		
	}

}
