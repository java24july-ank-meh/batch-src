package com.revature.game;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclarePrecedence;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class GamerImpl implements IGamer {

	@Before("execution(* com.revature.game.GameImpl.playGame(..))")
	public void insertGameInConsole() {
		System.out.println("Insert Legend of Zelda in the console");
	}
	
	@Before("execution(* com.revature.game.GameImpl.playGame(..))")
	public void loadGame() {
		System.out.println("Load game for play");
		
	}

	@Before("execution(* com.revature.game.GameImpl.playGame(..))")
	public void getGame() {
		System.out.println("Select Legend of Zelda");
		
	}

	

	@AfterReturning("execution(* com.revature.game.GameImpl.playGame(..))")
	public void ejectGame() {
		System.out.println("Eject the game from the console");
		
	}

	@After("execution(* com.revature.game.GameImpl.playGame(..))")
	public void powerGameOff() {
		System.out.println("Turn console off");
	}

	@Around("execution(* com.revature.game.GameImpl.playGame(..))")
	public void toggleLoadSave(ProceedingJoinPoint joinpoint) throws Throwable {
		System.out.println("Turn power on for console");
		joinpoint.proceed();
		System.out.println("Save the game");
	}

	@AfterThrowing("execution(* com.revature.game.GameImpl.playGame(..))")
	public void gameFreeze() {
		System.out.println("GAME FROZE!!! Blow in the cartridge...SOS!");
		
	}
	
	
}
