package com.purbarun.hibernate.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.purbarun.hibernate.dto.Address;
import com.purbarun.hibernate.dto.Employee;

@TestMethodOrder(OrderAnnotation.class)
@DisplayName("EmployeeDao Under Test")
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
		Address homeAddress = new Address();
		homeAddress.setStreet("76 Park Street");
		homeAddress.setCity("Kolkata");
		homeAddress.setState("Bengal");
		homeAddress.setPincode(75645);

		Address officeAddress = new Address();
		
		officeAddress.setStreet("100 ft Rd");
		officeAddress.setCity("Bangalore");
		officeAddress.setState("Karnataka");
		officeAddress.setPincode(53434);

		Employee emp = new Employee();
		emp.setUserName("Rakesh");
		emp.getListOfAddresses().add(homeAddress);
		emp.getListOfAddresses().add(officeAddress);
		dao.saveEmployee(emp);
	}

	@Test
	@DisplayName("Read Employee Test")
	@Order(2)
	void findTest() {
		Address homeAddress = new Address();
		homeAddress.setStreet("76 Park Street");
		homeAddress.setCity("Kolkata");
		homeAddress.setState("Bengal");
		homeAddress.setPincode(75645);

		Address officeAddress = new Address();
		officeAddress.setStreet("100 ft Rd");
		officeAddress.setCity("Bangalore");
		officeAddress.setState("Karnataka");
		officeAddress.setPincode(53434);
		
		Employee emp=dao.findById(1);
		List<Address> expectedListOfAddresses=emp.getListOfAddresses();
		assertThat(expectedListOfAddresses).contains(homeAddress,officeAddress);
	}
}
