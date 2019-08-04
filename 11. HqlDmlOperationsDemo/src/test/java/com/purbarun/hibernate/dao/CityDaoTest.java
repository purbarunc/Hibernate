package com.purbarun.hibernate.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.purbarun.hibernate.dao.CityDao;

@DisplayName("City Dao Under Test")
class CityDaoTest {
	CityDao dao;

	@BeforeEach
	void createDaoObject() {
		dao = new CityDao();
	}

	@Test
	@DisplayName("Test for Update")
	void updateTest() {
		int result = dao.update(1, "Kolkata");
		assertEquals(1, result, "1 row should be affected");
	}

	@Test
	@DisplayName("Test for Delete")
	void deleteTest() {
		int result = dao.delete(1);
		assertEquals(1, result, "1 row should be affected");
	}
}
