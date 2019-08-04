package com.purbarun.hibernate.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.purbarun.hibernate.dto.City;
import com.purbarun.hibernate.utilities.SingletonSessionFactory;

/**
 * Similar to HQL named query here we will use named native fires native sql
 * queries which are defined in the DTO class and accssed by its name.
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
	 * @return city object
	 */
	public City findById(int id) {
		City city = null;
		try (Session session = sessionFactory.openSession()) {
			Query<?> query = (Query<?>) session.createNamedQuery("City_FindById");
			query.setParameter("id", id);
			city = (City) query.getSingleResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return city;
	}

	/**
	 * Method to get all city enities.
	 *
	 * @return list of city entities
	 */
	@SuppressWarnings("unchecked")
	public List<City> getAll() {
		List<City> listOfCities = null;
		try (Session session = sessionFactory.openSession()) {
			Query<?> query = session.createNamedQuery("City_GetAll");
			listOfCities = (List<City>) query.getResultList();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return (List<City>) listOfCities;
	}
}
