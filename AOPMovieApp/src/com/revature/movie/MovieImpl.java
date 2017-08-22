package com.revature.movie;

import org.springframework.stereotype.Component;

@Component("movie")
public class MovieImpl implements IMovie {

	@Override
	public void watchMovie() throws Exception{
		System.out.println("Watching Tron");
		throw new Exception();
	}

}
