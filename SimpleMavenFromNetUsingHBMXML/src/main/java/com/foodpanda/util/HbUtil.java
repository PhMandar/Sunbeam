package com.foodpanda.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HbUtil {
	private static final SessionFactory factory = createSessionFactory();
	private static SessionFactory createSessionFactory() {
		Configuration cfg = new Configuration();
		cfg.configure();
		return cfg.buildSessionFactory();
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
