package com.purbarun.hibernate.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.purbarun.hibernate.dto.Employee;
import com.purbarun.hibernate.dto.Passport;

@DisplayName("EmployeeDao Under Test")
@TestMethodOrder(OrderAnnotation.class)
class EmployeeDaoTest {
	EmployeeDao dao;

	@BeforeEach
	void createDaoObjects() {
		dao = new EmployeeDao();
	}

	@Test
	@DisplayName("Save Employee Test")
	@Order(1)
	void createTest() {
		Employee emp = new Employee();
		Passport passport = new Passport();
		emp.setName("Vikas");
		passport.setPlaceOfIssue("Mumbai");
		emp.setPassport(passport);
		dao.saveEmployee(emp);
	}

	@Test
	@DisplayName("Read Employee Test")
	@Order(2)
	void findTest() {
		Employee actualEmployee=dao.findById(1);
		assertEquals("Vikas", actualEmployee.getName(),"Names should exactly match");
		Passport actualPassport=actualEmployee.getPassport();
		assertEquals("Mumbai", actualPassport.getPlaceOfIssue(),"Place of issue should match");
	}
}
