package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CacheExample {

	public static void main(String[] args) {
		try{
			//SessionFactory
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			//Session1
			Session session1 = sf.openSession();
			//Session2
			Session session2 = sf.openSession();
			
			Person person1 = (Person)session1.load(Person.class, 3L);
			System.out.println(person1);
			
			Person person2 = (Person)session2.load(Person.class, 3L);
			System.out.println(person2);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
