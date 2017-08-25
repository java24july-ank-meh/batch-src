package com.revature.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Bike implements Vehicle{

	@Autowired
	Harley bike;
	
	/*public void setBike(Harley bike) {
		this.bike = bike;
	}*/

	@Override
	public void drive() {
		bike.getNameOfBike();
		System.out.println(" driving");
		
	}

	@Override
	public void stop() {
		bike.getNameOfBike();
		System.out.println(" stopping");
		
	}

}
