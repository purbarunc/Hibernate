package com.purbarun.hibernate.dao;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.purbarun.hibernate.dto.City;

@DisplayName("CityDao Under Test")
class CityDaoTest {
	CityDao dao;

	@BeforeEach
	void createDaoObject() {
		dao = new CityDao();
	}

	@Test
	@DisplayName("Filtered Selection Test")
	void findByIdTest() {
		CityDao dao = new CityDao();
		City actualCity = dao.findById(1);
		City expectedCity = new City();
		expectedCity.setId(1);
		expectedCity.setState("WB");
		expectedCity.setName("Kolkata");
		assertThat(actualCity).isEqualToComparingFieldByField(expectedCity);
	}

	@Test
	@DisplayName("Unfiltered Selection Test")
	void getAllTest() {
		CityDao dao = new CityDao();
		List<City> actualList = dao.getAll();
		City city1 = new City();
		city1.setId(1);
		city1.setState("WB");
		city1.setName("Kolkata");
		City city2 = new City();
		city2.setId(2);
		city2.setState("TN");
		city2.setName("Chennai");
		assertThat(actualList).contains(city1, city2);
	}
}
