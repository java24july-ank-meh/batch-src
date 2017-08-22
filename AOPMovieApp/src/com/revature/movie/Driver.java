package com.revature.movie;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {

	public static void main(String[] args) throws Exception {
		//Load appcontext
		ApplicationContext ctx = new ClassPathXmlApplicationContext("appContext.xml");
		//Fetch the bean into MovieImpl
		IMovie movie = (IMovie)ctx.getBean("movie");
		movie.watchMovie();
	}

}
