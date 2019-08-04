package com.purbarun.hibernate.dao;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.purbarun.hibernate.dto.City;

@DisplayName("CityDao Under Test")
class CityDaoTest {

	@Test
	@DisplayName("Filtered Selection Test")
	void findByIdTest() {
		CityDao dao = new CityDao();
		List<City> actualCity=null;
		actualCity=dao.findById(1);
		City city=new City();
		city.setId(1);
		city.setState("WB");
		city.setName("Kolkata");
		assertEquals(actualCity.size(), 1,"Should always give 1 entity");
		assertThat(actualCity).contains(city);
	}

}
