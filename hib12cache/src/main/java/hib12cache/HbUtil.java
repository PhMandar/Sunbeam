package hib12cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HbUtil {
	/*private static final SessionFactory factory = createSessionFactory();
	private static ServiceRegistry serviceRegistry;

	private static SessionFactory createSessionFactory() {
		 For Hibernate version 5.2.12.Final 
		  try {
			serviceRegistry = new StandardServiceRegistryBuilder()
					.configure()
					.build();
		
			Metadata metadata = new MetadataSources(serviceRegistry)
					.getMetadataBuilder()
					.build();
			sessionFactory = metadata.getSessionFactoryBuilder().build();
		}catch(Exception mex) {
			mex.printStackTrace();
			serviceRegistry.close();
		}
		
		Configuration conf = new Configuration();
		conf.configure();
		return conf.buildSessionFactory();
	}
	public static SessionFactory getSessionFactory() {
		return factory;
	}
	public static Session getSession() {
		return factory.getCurrentSession();
	}
	public static void beginTransaction() {
		factory.getCurrentSession()
			.getTransaction().begin();
	}
	public static void commitTransaction() {
		factory.getCurrentSession()
			.getTransaction().commit();
	}
	public static void rollbackTransaction() {
		factory.getCurrentSession()
			.getTransaction().rollback();
	}
	public static void shutdown() {
		factory.close();
	}*/
	
	private static final SessionFactory factory = createSessionFactory();
	private static SessionFactory createSessionFactory() {
		Configuration conf = new Configuration();
		conf.configure();
		return conf.buildSessionFactory();
	}
	public static SessionFactory getSessionFactory() {
		return factory;
	}
	public static Session getSession() {
		return factory.openSession();
	}

	public static void shutdown() {
		factory.close();
	}
}
