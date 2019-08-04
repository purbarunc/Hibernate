package com.purbarun.hibernate.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.purbarun.hibernate.dto.User;
import com.purbarun.hibernate.utilities.SingletonSessionFactory;

/**
 * DAO Class (Data Access Object) which will perform all the data operations and
 * will act as the Data Access Layer in our application.
 * 
 * @author Purbarun Chakrabarti
 *
 */

public class UserDao {

	/** The session factory object. */
	SessionFactory sessionFactoryObj = null;

	/**
	 * Zero Parameterized constructor to fetch the Session Factory Object.
	 * SessionFactory object is ready as soon as the Object of the class is created.
	 */
	public UserDao() {
		sessionFactoryObj = SingletonSessionFactory.getSessionFactory();
	}

	/**
	 * Method to create a new user or a new row in the database.
	 *
	 * @param userdto (the user entity object)
	 */
	public void createNewUser(User userdto) {
		Transaction transaction = null;
		try (Session session = sessionFactoryObj.openSession()) {
			transaction = session.beginTransaction();
			session.save(userdto);
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
		User user = null;
		try (Session session = sessionFactoryObj.openSession()) {
			user = session.get(User.class, primaryKey);
		} catch (HibernateException e) {
			e.printStackTrace();
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
		try (Session session = sessionFactoryObj.openSession()) {
			transaction = session.beginTransaction();
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
		try (Session session = sessionFactoryObj.openSession()) {
			transaction = session.beginTransaction();
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
