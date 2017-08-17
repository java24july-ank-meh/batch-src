package com.revature.hib;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

	public static StandardServiceRegistry registry;
	public static SessionFactory sf;
	
	public static SessionFactory getSessionFactory()
	{
		if(sf == null)
		{
			//create registry
			registry = new StandardServiceRegistryBuilder().configure().build();
			
			//create metadatasources
			MetadataSources sources = new MetadataSources(registry);
			
			//create metadata
			Metadata metadata = sources.getMetadataBuilder().build();
			
			//create SessionFactory
			sf = metadata.getSessionFactoryBuilder().build();
		}
		return sf;
	}
	
	public static void Shutdown()
	{
		if(registry != null)
		{
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}
}
