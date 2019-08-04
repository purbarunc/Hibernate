package com.purbarun.hibernate.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.purbarun.hibernate.dto.City;
import com.purbarun.hibernate.utilities.SingletonSessionFactory;

/**
 * Sometimes there may be a need to fire database specific sql queries similar
 * to legacy jdbc api. Here we do not write queries using Java Mapped Objects.
 * 
 * @author Purbarun Chakrabarti
 */
public class CityDao {
	SessionFactory sessionFactory = null;

	public CityDao() {
		sessionFactory = SingletonSessionFactory.getSessionFactory();
	}

	/**
	 * Method to find an entity by its id.
	 *
	 * @param primary key
	 * @return list of objects
	 */
	@SuppressWarnings("unchecked")
	public List<City> findById(int id) {
		List<City> city = null;
		String selectQry = "select * from citydb where cityid=:cid";
		try (Session session = sessionFactory.openSession()) {
			Query<?> query = (Query<?>) session.createNativeQuery(selectQry, City.class);
			query.setParameter("cid", id);
			city = (List<City>) query.getResultList();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return city;
	}
}
