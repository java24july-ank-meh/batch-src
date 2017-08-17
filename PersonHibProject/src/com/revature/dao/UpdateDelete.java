package com.revature.dao;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class UpdateDelete {

	public static void main(String[] args) {
		try{
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();
			
			//delete
			/*Person wonderWoman = (Person)session.load(Person.class, 1L);
			System.out.println(wonderWoman);
			
			session.delete(wonderWoman);
			session.flush();
			tx.commit();
			wonderWoman = null;
			System.out.println(wonderWoman);*/
			
			//update
			Person mickeyMouse = (Person)session.load(Person.class, 2L);
			mickeyMouse.setEmail("mm@gmail.com");
			session.saveOrUpdate(mickeyMouse);
			session.flush();
			tx.commit();
			System.out.println("done");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
