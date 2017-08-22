package com.revature.game;

import org.springframework.stereotype.Component;

@Component("game")
public class GameImpl implements IGame{

	@Override
	public void playGame() throws Exception {
		System.out.println(" --- Playing Legend of Zelda --- ");
	}

}
