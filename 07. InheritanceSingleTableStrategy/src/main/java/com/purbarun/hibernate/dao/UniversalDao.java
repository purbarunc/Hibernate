package com.purbarun.hibernate.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.purbarun.hibernate.utilities.SingletonSessionFactory;


/**
 * Example to demonstrate Inheritance in hibernate.
 *
 * @param <T> the generic type
 */
public class UniversalDao<T> {
	/** The session factory object. */
	private SessionFactory sessionFactory = null;
	
	/** The entity. */
	private Class<T> entity;

	/**
	 * Zero Parameterized constructor to fetch the Session Factory Object.
	 *
	 * @param entity the entity
	 */
	public UniversalDao(Class<T> entity) {
		sessionFactory = SingletonSessionFactory.getSessionFactory();
		this.entity = entity;
	}

	/**
	 * Method to create a new entity or a new row in the database.
	 *
	 * @param Type t
	 */
	public void save(T t) {
		Transaction transaction = null;
		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			session.save(t);
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	/**
	 * Method to read an entity based on the primary key or to check whether
	 * any entity with that id exists or not.
	 *
	 * @param primaryKey 
	 * @return entity instance
	 */
	public T findById(int primaryKey) {
		T t = null;
		try (Session session = sessionFactory.openSession()) {
			t = session.get(entity, primaryKey);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return t;
	}
}
