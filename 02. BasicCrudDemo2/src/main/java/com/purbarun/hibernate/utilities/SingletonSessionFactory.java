package com.purbarun.hibernate.utilities;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * A factory for creating Singleton SessionFactory objects.
 */
public class SingletonSessionFactory {

	private SingletonSessionFactory() {

	}

	/** The Constant sessionFactoryObj. */
	private static final SessionFactory sessionFactory;
	static {
		Configuration configuration = new Configuration();
		configuration.configure();
		sessionFactory = configuration.buildSessionFactory();
	}

	/**
	 * Gets the session factory.
	 *
	 * @return the session factory object
	 */
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
