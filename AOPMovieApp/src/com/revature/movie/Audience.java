package com.revature.movie;

import org.aspectj.lang.ProceedingJoinPoint;

public interface Audience {

	public void buyTicket();
	public void sit();
	public void phoneOff();
	public void phoneOn();
	public void stand();
	public void exit();
	public void useRestroom(ProceedingJoinPoint proceed) throws Throwable;
}
