package com.purbarun.hibernate.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.purbarun.hibernate.dto.City;
import com.purbarun.hibernate.utilities.SingletonSessionFactory;

/**
 * Named Queries is a nice practise for HQL Operations where we define all the
 * queries by name in the DTO class itself. The queries are accessed by its name
 * defined in the Bean Class.
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
			Query<?> query = session.createNamedQuery("City_FindById", City.class);
			query.setParameter("id", id);
			city = (City) query.getSingleResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return city;
	}

	/**
	 * Method to get all entities.
	 *
	 * @return list of cities
	 */
	@SuppressWarnings("unchecked")
	public List<City> getAll() {
		List<City> listOfCities = null;
		try (Session session = sessionFactory.openSession()) {
			Query<?> query = session.createNamedQuery("City_GetAll", City.class);
			listOfCities = (List<City>) query.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return (List<City>) listOfCities;
	}
}
