package com.revature.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Artist;
import com.revature.dao.ArtistDao;

@Transactional(readOnly=true, propagation=Propagation.NEVER)
public class Driver {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		ArtistDao dao = (ArtistDao) ac.getBean(ArtistDao.class);
		//System.out.println(dao.findByName("Fretwork"));
		/*Artist artist = new Artist(100101, "Kanye West");
		dao.save(artist);*/
		for (Artist artist : dao.findAll()) {
			System.out.println(artist);
		}
		
	}
}
