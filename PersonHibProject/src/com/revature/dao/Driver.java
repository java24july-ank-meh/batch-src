package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Driver {

	public static void main(String[] args) {
		try{
			//Session Factory
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			
			//Session
			Session session = sf.openSession();
			
			//Transaction
			Transaction tx = session.beginTransaction();
			
			//Persist person object
			Person person = new Person("Donald", "Duck", "dd@gmail.com");
			
			//Insert
			session.save(person);
			
			//Flush
			session.flush();
			
			//Commit
			tx.commit();
			
			//close session
			session.close();
			
			System.out.println("Done!");
			
			
			
			
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
