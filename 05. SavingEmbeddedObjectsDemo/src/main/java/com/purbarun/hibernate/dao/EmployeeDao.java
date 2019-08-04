package com.purbarun.hibernate.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.purbarun.hibernate.dto.Employee;
import com.purbarun.hibernate.utilities.SingletonSessionFactory;

/**
 * Demonstration of saving a two composite attributes home address and office
 * address into an employee entity. Home Address and Office Address are embedded
 * objects of type Address in Employee.
 * 
 * @author Purbarun Chakrabrti
 */
public class EmployeeDao {
	SessionFactory sessionFactory = null;

	/**
	 * Zero Parameterized constructor to fetch the Session Factory Object.
	 * SessionFactory object is ready as soon as the Object of the class is created.
	 */
	public EmployeeDao() {
		sessionFactory = SingletonSessionFactory.getSessionFactory();
	}

	/**
	 * Method to create a new employee or a new row in the database.
	 *
	 * @param employee instance
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

	public Employee findById(int id) {
		Employee emp = null;
		try (Session session = sessionFactory.openSession()) {
			emp = session.get(Employee.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return emp;
	}
}
