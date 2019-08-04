package com.purbarun.hibernate.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.purbarun.hibernate.dto.Employee;
import com.purbarun.hibernate.utilities.SingletonSessionFactory;

/**
 * This example is all about saving collection. Configurations are all done in
 * the DTO class.
 * 
 * @author Purbarun Chakrabarti
 */
public class EmployeeDao {
	SessionFactory sessionFactoryObj = null;

	/**
	 * Zero Parameterized constructor to fetch the Session Factory Object.
	 * SessionFactory object is ready as soon as the DAO Object is created.
	 */
	public EmployeeDao() {
		sessionFactoryObj = SingletonSessionFactory.getSessionFactory();
	}

	/**
	 * Method to create a new employee or a new row in the database.
	 *
	 * @param employee instance
	 */
	public void saveEmployee(Employee emp) {
		Transaction transaction = null;
		try (Session session = sessionFactoryObj.openSession();) {
			transaction = session.beginTransaction();
			session.save(emp);
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	/**
	 * Find employee by id.
	 *
	 * @param primary key
	 * @return employee
	 */
	public Employee findById(int id) {
		Employee user = null;
		try (Session session = sessionFactoryObj.openSession()) {
			user = session.get(Employee.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return user;
	}
}
