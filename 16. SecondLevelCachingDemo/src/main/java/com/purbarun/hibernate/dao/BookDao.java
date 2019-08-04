package com.purbarun.hibernate.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.purbarun.hibernate.dto.Book;
import com.purbarun.hibernate.utilities.SingletonSessionFactory;

/**
 * This example demonstrates the use of Second Level Cache Ehcache apart from
 * Session (First Level Cache).We have used the core Ehcache API for the
 * demonstration in the BookDaoTest class.
 * 
 * @author Purbarun Chakrabarti
 */
public class BookDao {
	SessionFactory sessionFactory = null;

	public BookDao() {
		sessionFactory = SingletonSessionFactory.getSessionFactory();
	}

	/**
	 * Save A Book object.
	 *
	 * @param book instance
	 */
	public void saveBook(Book book) {
		Transaction transaction = null;
		try (Session session = sessionFactory.openSession();) {
			transaction = session.beginTransaction();
			session.save(book);
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	/**
	 * Find book by id.
	 *
	 * @param primary key
	 * @return book object
	 */
	public Book findById(int id) {
		Book book = null;
		try (Session session = sessionFactory.openSession()) {
			book = session.get(Book.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return book;
	}
}
