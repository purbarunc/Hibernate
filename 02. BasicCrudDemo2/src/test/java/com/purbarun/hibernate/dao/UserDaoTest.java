package com.purbarun.hibernate.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.purbarun.hibernate.dto.User;

@TestMethodOrder(OrderAnnotation.class)
@DisplayName("UserDao Under Test")
class UserDaoTest {
	UserDao dao;

	@BeforeEach
	void createDaoObject() {
		dao = new UserDao();
	}

	@Test
	@DisplayName("Save new User Test")
	@Order(1)
	void createTest() {
		User user = new User();
		user.setName("Amit");
		dao.createNewUser(user);
	}

	@Test
	@DisplayName("Find User by Id Test")
	@Order(2)
	void readTest() {
		User user = dao.findById(1);
		assertEquals(user.getName(), "Amit", "Name should match");
	}

	@Test
	@DisplayName("Update User by Id Test")
	@Order(3)
	void updateTest() {
		User user = new User();
		user.setId(1);
		user.setName("Arun");
		dao.updateUserById(user);
	}

	@Test
	@DisplayName("Delete User by Id Test")
	@Order(4)
	void deleteTest() {
		dao.deleteUserById(1);
	}
}
