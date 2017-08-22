package com.revature.game;

import org.aspectj.lang.ProceedingJoinPoint;

public interface IGamer {

	public void loadGame();
	public void getGame();
	public void insertGameInConsole();
	public void ejectGame();
	public void powerGameOff();
	public void toggleLoadSave(ProceedingJoinPoint joinpoint) throws Throwable;
	public void gameFreeze();
}
