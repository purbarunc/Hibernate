package com.purbarun.hibernate.utilities;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SingletonSessionFactory {
	/** The Constant sessionFactoryObj. */
	private static final SessionFactory sessionFactory;
	static {
		Configuration configurationObj = new Configuration();
		configurationObj.configure();
		sessionFactory = configurationObj.buildSessionFactory();
	}

	/**
	 * Gets the session factory.
	 *
	 * @return the session factory
	 */
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
