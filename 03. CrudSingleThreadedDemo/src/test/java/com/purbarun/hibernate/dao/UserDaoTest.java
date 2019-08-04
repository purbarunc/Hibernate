package com.purbarun.hibernate.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.purbarun.hibernate.dto.User;

@TestMethodOrder(OrderAnnotation.class)
@DisplayName("UserDao under Test")
class UserDaoTest {
	UserDao dao;

	@BeforeEach
	void createDaoObject() {
		dao = new UserDao();
	}

	@Test
	@DisplayName("Save New User Test")
	@Order(1)
	void createTest() {
		User user = new User();
		user.setName("Vikas");
		dao.createNewUser(user);
	}

	@Test
	@DisplayName("Find User by Id Test")
	@Order(2)
	void readTest() {
		User user = dao.findById(1);
		assertEquals(user.getName(), "Vikas");
	}

	@Test
	@DisplayName("Update User by Id Test")
	@Order(3)
	void updateTest() {
		User user = new User();
		user.setId(1);
		user.setName("Vishal");
		dao.updateUserById(user);
	}

	@Test
	@DisplayName("Delete User by Id Test")
	@Order(4)
	void deleteTest() {
		dao.deleteUserById(1);
	}
}
