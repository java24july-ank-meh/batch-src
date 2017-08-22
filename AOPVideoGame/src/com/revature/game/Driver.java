package com.revature.game;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {

	public static void main(String[] args) throws Exception {
		//Load the appcontext.xml
		ApplicationContext ctx = new ClassPathXmlApplicationContext("appContext.xml");
		//Fetch Game object from ctx
		IGame game = (IGame)ctx.getBean("game");
		//call business logic methods
		game.playGame();
	}

}
