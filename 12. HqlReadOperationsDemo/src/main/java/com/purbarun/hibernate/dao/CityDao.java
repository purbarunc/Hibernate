package com.purbarun.hibernate.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.purbarun.hibernate.dto.City;
import com.purbarun.hibernate.utilities.SingletonSessionFactory;

/**
 * DAO Class for select operations.
 * 
 * @author Purbarun Chakrabarti
 */
public class CityDao {
	SessionFactory sessionFactory = null;

	public CityDao() {
		sessionFactory = SingletonSessionFactory.getSessionFactory();
	}

	/**
	 * Method to get a city entity by its id.
	 *
	 * @param id the id
	 * @return unique city entity
	 */
	public City findById(int id) {
		String readQry = "from City where id=:id";
		City city = null;
		try (Session session = sessionFactory.openSession()) {
			Query<?> query = session.createQuery(readQry);
			query.setParameter("id", id);
			city = (City) query.uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return city;
	}

	/**
	 * Method to get all rows of City Entity.
	 *
	 * @return list of cities
	 */
	@SuppressWarnings("unchecked")
	public List<City> getAll() {
		String readQry = "from City";
		List<City> listOfCities = null;
		try (Session session = sessionFactory.openSession()) {
			Query<?> query = session.createQuery(readQry);
			listOfCities = (List<City>) query.list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return (List<City>) listOfCities;
	}

	/**
	 * Method for Projection operation.
	 *
	 * Note: This Method is experimental since it is not unit tested. Moreover, it
	 * is very complex and thus not a best practise. For this use JPA Criteria API.
	 * 
	 * @return list of list of projected columns as objects.
	 */
	@SuppressWarnings("unchecked")
	public List<List<Object>> projection() {
		String readQry = "select state,name from City";
		List<List<Object>> proj = null;
		try (Session session = sessionFactory.openSession()) {
			Query<?> query = session.createQuery(readQry);
			proj = (List<List<Object>>) query.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return proj;
	}
}
