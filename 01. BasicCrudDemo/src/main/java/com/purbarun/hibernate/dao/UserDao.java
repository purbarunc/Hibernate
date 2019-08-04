package com.purbarun.hibernate.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.purbarun.hibernate.dto.User;

/**
 * DAO Class (Data Access Object) which will perform all the data operations and
 * will act as the Data Access Layer in our application.
 * 
 * @author Purbarun Chakrabarti
 */
public class UserDao {

	/** The configuration obj. */
	private Configuration configuration = null;

	/** The session factory obj. */
	private SessionFactory sessionFactory = null;

	/**
	 * Instantiates a new user dao. Configuration and SessionFactory objects are
	 * ready as soon as UserDao is instantiated.
	 */
	public UserDao() {
		configuration = new Configuration();
		configuration.configure();
		sessionFactory = configuration.buildSessionFactory();
	}

	/**
	 * Creates the new user.
	 *
	 * @param userdto (the user entity object)
	 */
	public void createNewUser(User user) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(user);
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
	}

	/**
	 * Method to read an user entity based on the primary key or to check whether
	 * any entity with that id exists or not.
	 *
	 * @param primaryKey (the primary key)
	 * @return an user entity
	 */
	public User findUserById(int primaryKey) {
		Session session = null;
		User user = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			user = session.get(User.class, primaryKey);
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return user;
	}

	/**
	 * Method to Update user by id.
	 *
	 * @param primaryKey the primary key
	 * @param newName    the new name
	 */
	public void updateUserById(int primaryKey, String newName) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			User user = session.get(User.class, primaryKey);
			user.setName(newName);
			session.update(user);
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
	}

	/**
	 * Method to delete user by id.
	 *
	 * @param primaryKey (the primary key)
	 */
	public void deleteUserById(int primaryKey) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			User user = session.get(User.class, primaryKey);
			session.delete(user);
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
	}
}
