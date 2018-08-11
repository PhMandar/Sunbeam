package com.foodpanda.main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.foodpanda.entity.Items;

public class MainClass {	
	private static SessionFactory buildSessionFactory() {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		
		ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		SessionFactory  sessionFactory = config.buildSessionFactory(serviceRegistryObj);
		return sessionFactory; 
	}
	
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		try {
			sessionFactory = buildSessionFactory();
			
			// 0. To retrieve items
			// List<Items> lstItems = getAllItems(sessionFactory);
			
			// 1. To add items
			// Items item = new Items(35, "Sweets", "Gulab Jamun", "Gulab Jamun", 60.0);
			// addItem(sessionFactory, item);
			getItemById(sessionFactory, 35);
			
			// 2. To update items
			/*Items item = getItemById(sessionFactory, 35);
			item.setInfo("New" + item.getInfo());
			updateItem(sessionFactory, item);*/
			
			// 3. To delete items
			/*Items item = getItemById(sessionFactory, 35);
			if(item != null)
				deleteItem(sessionFactory, item);
			getItemById(sessionFactory, 35);*/
		}
		finally {
			if(sessionFactory != null)
				sessionFactory.close();
		}
	}

	private static void deleteItem(SessionFactory sessionFactory, Items itemToDelete) {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.delete(itemToDelete);
		
		session.close();
	}

	private static void updateItem(SessionFactory sessionFactory, Items updatedItem) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(updatedItem);
		System.out.println("\n\n Item \n" + updatedItem );
		System.out.println("gets updated successfully ");
		session.getTransaction().commit();
		session.close();
	}

	private static Items getItemById(SessionFactory sessionFactory, int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Items item = (Items) session.get(Items.class, id);
		System.out.printf("\n\n Item found with id %d is \n", id);
		System.out.println(item);
		session.close();
		return item;
	}

	private static List<Items> getAllItems(SessionFactory sessionFactory) {
		List<Items> lstItems = new ArrayList<Items>();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("From Items");
		@SuppressWarnings("unchecked")
		List<Object> lstResult = query.list();
		Items item = null;
		System.out.println("\n\nItems table contents : \n");
		for(Object obj : lstResult) {
			if(obj instanceof Items) {
				item = (Items)obj;
				lstItems.add(item);
				System.out.println(item);
			}
		}
		System.out.println("\n\n");
		session.close();
		return lstItems;
	}

	private static void addItem(SessionFactory sessionFactory, Items item) {
		Session session= null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(item);
			System.out.println("\n\n Item \n" + item );
			System.out.println("gets added successfully ");
			session.getTransaction().commit();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(session != null)
				session.close();
		}
	}

}
