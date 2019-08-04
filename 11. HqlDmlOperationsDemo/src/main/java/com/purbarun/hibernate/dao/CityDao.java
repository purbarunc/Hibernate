package com.purbarun.hibernate.dao;

import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.purbarun.hibernate.utilities.SingletonSessionFactory;

/**
 * DAO Class to perform HQL Operations.
 * 
 * @author Purbarun Chakrabarti
 */
public class CityDao {
	SessionFactory sessionFactory = null;

	public CityDao() {
		sessionFactory = SingletonSessionFactory.getSessionFactory();
	}

	/**
	 * Method to update an entity using HQL Queries.
	 *
	 * @param cid   the cid
	 * @param cname the cname
	 * @return no. of rows affected
	 */
	public int update(int cid, String cname) {
		Transaction transaction = null;
		String updateQry = "update City set name=: cname where id=:cid";
		int res = 0;
		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			Query<?> query = session.createQuery(updateQry);
			query.setParameter("cname", cname);
			query.setParameter("cid", cid);
			res = query.executeUpdate();
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return res;
	}

	/**
	 * Method to delete an entity or row.
	 *
	 * @param cid the cid
	 * @return no. of rows affected
	 */
	public int delete(int cid) {
		Transaction transaction = null;
		String deleteQry = "delete from City where id=:cid";
		int res = 0;
		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			Query<?> query = session.createQuery(deleteQry);
			query.setParameter("cid", cid);
			res = query.executeUpdate();
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return res;
	}
}
