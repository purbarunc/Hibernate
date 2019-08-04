package com.purbarun.hibernate.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.purbarun.hibernate.dto.Team;
import com.purbarun.hibernate.utilities.SingletonSessionFactory;

/**
 * Example to demonstrate One-to-Many Mapping. Team can have many players but
 * not reverse.
 * 
 * @author Purbarun Chakrabarti
 */
public class TeamDao {

	/** The session factory. */
	SessionFactory sessionFactory = null;

	/**
	 * Zero Parameterized constructor to fetch the Session Factory Object.
	 * SessionFactory object is ready as soon as the DAO Object is created.
	 */
	public TeamDao() {
		sessionFactory = SingletonSessionFactory.getSessionFactory();
	}

	/**
	 * Save team.
	 *
	 * @param team object
	 */
	public void saveTeam(Team team) {
		Transaction transaction = null;
		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			session.save(team);
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	/**
	 * Find team by id.
	 *
	 * @param primary key
	 * @return team instance
	 */
	public Team findById(int id) {
		Team team = null;
		try (Session session = sessionFactory.openSession()) {
			team = session.get(Team.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return team;
	}
}
