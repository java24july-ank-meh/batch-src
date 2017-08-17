package com.revature.bank;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class BankCustomer {

	public static void main(String[] args) {
		try{
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();
			
			/*Customer customer = new Customer(2000L, "Billy", "Wilson");
			session.save(customer);
			
			BankAccount account = new BankAccount(123456L, "Checking", 5000.00, customer);
			session.save(account);*/
			
			
			Customer customer = (Customer)session.load(Customer.class, 2000L);
			System.out.println(customer);
			/*BankAccount account = new BankAccount(123555L, "Savings", 15000.00, customer);
			session.save(account);*/
						
			tx.commit();
			
			System.out.println("created!");
			
			session.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
