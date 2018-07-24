package com.foodpanda.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class MainClass {

	static Items item;
	static Session session;
	static SessionFactory sessionFactory;
	
	private static SessionFactory buildSessionFactory() {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		
		ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		sessionFactory = config.buildSessionFactory(serviceRegistryObj);
		return sessionFactory; 
	}
	
	public static void main(String[] args) {
		try {
			session = buildSessionFactory().openSession();
			session.beginTransaction();
			
			
			item = new Items(31, "Miscellaneous", "Pizza", "Pizza", 101.50);
			session.save(item);
			session.getTransaction().commit();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			session.close();
		}
	}

}
