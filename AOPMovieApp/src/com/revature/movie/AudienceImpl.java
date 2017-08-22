package com.revature.movie;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component("audience")
@Aspect
public class AudienceImpl implements Audience {

	@Before("execution(* com.revature.movie.MovieImpl.watchMovie(..))")
	public void buyTicket() {
		System.out.println("Bought a ticket");
		
	}

	@Before("execution(* com.revature.movie.MovieImpl.watchMovie(..))")
	public void sit() {
		System.out.println("Sat down in theatre");		
	}

	@Before("execution(* com.revature.movie.MovieImpl.watchMovie(..))")
	public void phoneOff() {
		System.out.println("Turned phone off");
		
	}

	@AfterThrowing("execution(* com.revature.movie.MovieImpl.watchMovie(..))")
	public void badMovie()
	{
		System.out.println("*****BAD MOVIE*****");
		System.exit(0);
	}
	
	@After("execution(* com.revature.movie.MovieImpl.watchMovie(..))")
	public void phoneOn() {
		System.out.println("Turn phone back on");
		
	}

	@After("execution(* com.revature.movie.MovieImpl.watchMovie(..))")
	public void stand() {
		System.out.println("Getting ready to leave");
		
	}

	@AfterReturning("execution(* com.revature.movie.MovieImpl.watchMovie(..))")
	public void exit() {
		System.out.println("Exited the theatre");
		
	}

	@Around("execution(* com.revature.movie.MovieImpl.watchMovie(..))")
	public void useRestroom(ProceedingJoinPoint proceed) throws Throwable{
		System.out.println("Use restroom before movie");
		proceed.proceed();
		System.out.println("Use restroom after movie");
	}
	
	

}
