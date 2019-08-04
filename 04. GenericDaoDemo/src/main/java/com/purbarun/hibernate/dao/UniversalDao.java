package com.purbarun.hibernate.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.purbarun.hibernate.utilities.SingletonSessionFactory;

/**
 * Now consider we have n DTOs and for that we need
 * n DAOs which is quite unecessary and redundant.
 * To solve that problem we need to simplify the DAO 
 * with Java Generics so that it we can create DAO 
 * object as per the Entity we provide as the
 * parameter. And we call this Universal DAO.
 * 
 * @author Purbarun Chakrabarti
 *
 * @param Specific Type T
 */
public class UniversalDao<T> {

	/** The session factory object. */
	private SessionFactory sessionFactoryObj = null;
	private Class<T> entity;

	/**
	 * Zero Parameterized constructor to fetch the Session Factory Object.
	 *
	 * @param entity of Class T.
	 */
	public UniversalDao(Class<T> entity) {
		sessionFactoryObj = SingletonSessionFactory.getSessionFactory();
		this.entity = entity;
	}

	/**
	 * Method to create a new  or a new row in the database.
	 *
	 * @param user entity
	 */
	public void save(T t) {
		Transaction transaction = null;
		try (Session session = sessionFactoryObj.openSession()) {
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
	 * Method to read an user entity based on the primary key or to check whether
	 * any entity with that id exists or not.
	 *
	 * @param primaryKey the primary key
	 * @return An entity instance
	 */
	public T findById(int primaryKey) {
		T t = null;
		try (Session session = sessionFactoryObj.openSession()) {
			t = session.get(entity, primaryKey);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return t;
	}

	/**
	 * Method to update an entity. Here we will use the merge() method for the
	 * detached objects.
	 *
	 * @param Type t
	 */
	public void update(T t) {
		Transaction transaction = null;
		try (Session session = sessionFactoryObj.openSession()) {
			transaction = session.beginTransaction();
			session.merge(t);
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	/**
	 * Delete entity by id.
	 *
	 * @param primaryKey
	 */
	public void deleteById(int primaryKey) {
		Transaction transaction = null;
		try (Session session = sessionFactoryObj.openSession()) {
			transaction = session.beginTransaction();
			T t = findById(primaryKey);
			session.delete(t);
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}
}
