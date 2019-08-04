package com.purbarun.hibernate.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.purbarun.hibernate.dto.Student;
import com.purbarun.hibernate.utilities.SingletonSessionFactory;

public class StudentDao {

	SessionFactory sessionFactory = null;

	/**
	 * Zero Parameterized constructor to fetch the Session Factory Object.
	 * SessionFactory object is ready as soon as the DAO Object is created.
	 */
	public StudentDao() {
		sessionFactory = SingletonSessionFactory.getSessionFactory();
	}
	public void saveStudent(Student student ) {
		Transaction transaction = null;
		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			session.save(student);
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}
	public Student findById(int id) {
		Student student=null;
		try (Session session = sessionFactory.openSession()) {
			student = session.get(Student.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return student;
	}
}
