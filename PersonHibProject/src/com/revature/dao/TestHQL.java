package com.revature.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class TestHQL {

	public static void main(String[] args) {
		try{
			//SessionFactory
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			//Session
			Session session = sf.openSession();
			//Fetch one row
			Person person1 = (Person)session.get(Person.class, 2L);
			/*System.out.println(person1.getFname());
			System.out.println(person1);*/
			
			Person person2 = (Person)session.load(Person.class, 3L);
			/*System.out.println(person2.getFname());
			System.out.println(person2);*/
			
			//HQL
			String sql = "from Person person";
			Query query = session.createQuery(sql);
			List list = query.list();
			
			for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				Person person = (Person) iterator.next();
				//System.out.println(person);
			}
			
			//Criteria API
			Criteria criteria = session.createCriteria(Person.class);
			criteria.add(Restrictions.like("fname", "Wonder"));
			criteria.setMaxResults(5);
			List critList = criteria.list();
			
			for (Iterator iterator = critList.iterator(); iterator.hasNext();) {
				Person person = (Person) iterator.next();
				System.out.println(person);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
