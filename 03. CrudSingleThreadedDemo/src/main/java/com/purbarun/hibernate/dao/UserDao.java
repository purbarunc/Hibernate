package com.purbarun.hibernate.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.purbarun.hibernate.dto.User;
import com.purbarun.hibernate.utilities.SingletonSessionFactory;

/**
 * UserDao class for database related operations.
 * 
 * @author Purbarun Chakrabarti
 */
public class UserDao {
	/** The sessionFactory object. */
	SessionFactory sessionFactory = null;

	/**
	 * Zero Parameterized constructor to fetch the Session Factory Object.
	 * SessionFactory object is ready as soon as the Object of the class is created.
	 */
	public UserDao() {
		sessionFactory = SingletonSessionFactory.getSessionFactory();
	}

	/** The session. */
	private Session session = null;

	/**
	 * Gets the session.
	 *
	 * @return the session
	 */
	private Session getSession() {
		session = sessionFactory.getCurrentSession();
		return session;
	}

	/**
	 * Method to create a new user or a new row in the database.
	 *
	 * @param user the user
	 */
	public void createNewUser(User user) {
		Transaction transaction = null;
		try {
			transaction = getSession().beginTransaction();
			getSession().save(user);
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
	 * @param primaryKey (the primary key)
	 * @return An User entity instance
	 */
	public User findById(int primaryKey) {
		Transaction transaction = null;
		User user = null;
		try {
			transaction = getSession().beginTransaction();
			user = getSession().get(User.class, primaryKey);
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return user;
	}

	/**
	 * Method to update an entity. Here we will use the merge() method for the
	 * detached objects.
	 *
	 * @param user (the user entity object)
	 */
	public void updateUserById(User user) {
		Transaction transaction = null;
		try {
			transaction = getSession().beginTransaction();
			session.merge(user);
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	/**
	 * Delete user by id.
	 *
	 * @param primaryKey (the primary key)
	 */
	public void deleteUserById(int primaryKey) {
		Transaction transaction = null;
		try {
			transaction = getSession().beginTransaction();
			User user = session.get(User.class, primaryKey);
			session.delete(user);
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}
}
