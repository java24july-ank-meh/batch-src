package com.revature.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Artist;
import com.revature.dao.ArtistDao;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
@ContextConfiguration(locations= {"test-beans.xml"})
public class SpringDataTest {
	
	@Autowired
	ArtistDao artistDao;
	
	@Test
	public void testInsert()
	{
		Artist artist = new Artist(20000,"Ludacris");
		artist = artistDao.save(artist);
		assertEquals(artist, artistDao.findOne(245));
	}
	
	

}
