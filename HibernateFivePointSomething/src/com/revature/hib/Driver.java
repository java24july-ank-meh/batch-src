package com.revature.hib;
import org.hibernate.Session;

public class Driver {

	public static void main(String[] args) {
		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Contact contact = new Contact(5L, "Ankit", "Garg", 7033720321L, "ankit.garg@revature.com");
			session.save(contact);
			session.getTransaction().commit();
			HibernateUtil.Shutdown();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
