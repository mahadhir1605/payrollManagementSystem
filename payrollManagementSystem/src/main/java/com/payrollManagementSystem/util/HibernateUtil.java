package com.payrollManagementSystem.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	static SessionFactory sessionFactory = null;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {

			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.configure("hibernate/hibernate.cfg.xml").build();

			sessionFactory = new Configuration().buildSessionFactory(serviceRegistry);
		}
		return sessionFactory;
	}

}
