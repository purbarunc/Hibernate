package com.purbarun.hibernate.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.purbarun.hibernate.dto.Employee;
import com.purbarun.hibernate.utilities.SingletonSessionFactory;

/**
 * Example to demonstrate One-to-One Mapping.
 * 
 * @author Purbarun Chakrabarti
 */
public class EmployeeDao {
	SessionFactory sessionFactory = null;

	/**
	 * Zero Parameterized constructor to fetch the Session Factory Object.
	 * SessionFactory object is ready as soon as the DAO Object is created.
	 */
	public EmployeeDao() {
		sessionFactory = SingletonSessionFactory.getSessionFactory();
	}

	/**
	 * Method to create a new user or a new row in the database.
	 *
	 * @param emp the emp
	 */
	public void saveEmployee(Employee emp) {
		Transaction transaction = null;
		try (Session session = sessionFactory.openSession()) {
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
	 * Find by id.
	 *
	 * @param id the id
	 * @return the employee
	 */
	public Employee findById(int id) {
		Employee employee = null;
		try (Session session = sessionFactory.openSession()) {
			employee = session.get(Employee.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return employee;
	}
}
