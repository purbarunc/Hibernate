package com.purbarun.hibernate.dao;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.purbarun.hibernate.dto.Address;
import com.purbarun.hibernate.dto.Employee;

@DisplayName("EmployeeDao Under Test")
@TestMethodOrder(OrderAnnotation.class)
class EmployeeDaoTest {
	EmployeeDao dao;

	@BeforeEach
	void createDaoObject() {
		dao = new EmployeeDao();
	}

	@Test
	@DisplayName("Save New Employee Test")
	@Order(1)
	void createTest() {
		Employee emp = new Employee();
		Address homeAddress = new Address();
		Address officeAddress = new Address();

		homeAddress.setStreet("48 Belvedre Road");
		homeAddress.setCity("Kolkata");
		homeAddress.setState("WB");
		homeAddress.setPincode(79699);

		officeAddress.setStreet("28 100 Feet Rd.");
		officeAddress.setCity("Bengaluru");
		officeAddress.setState("Karnataka");
		officeAddress.setPincode(56745);

		emp.setUserName("Ramesh");
		emp.setHomeAddress(homeAddress);
		emp.setOfficeAddress(officeAddress);
		dao.saveEmployee(emp);
	}

	@Test
	@DisplayName("Read Employee Test")
	@Order(2)
	void findTest() {
		Employee emp = dao.findById(1);
		Address expectedHomeAddress = new Address();
		expectedHomeAddress.setStreet("48 Belvedre Road");
		expectedHomeAddress.setCity("Kolkata");
		expectedHomeAddress.setState("WB");
		expectedHomeAddress.setPincode(79699);

		Address expectedOfficeAddress = new Address();
		expectedOfficeAddress.setStreet("28 100 Feet Rd.");
		expectedOfficeAddress.setCity("Bengaluru");
		expectedOfficeAddress.setState("Karnataka");
		expectedOfficeAddress.setPincode(56745);

		Address actualHomeAddress = emp.getHomeAddress();
		Address actualOfficeAddress=emp.getOfficeAddress();
		assertThat(expectedHomeAddress).isEqualToComparingFieldByField(actualHomeAddress);
		assertThat(expectedOfficeAddress).isEqualToComparingFieldByField(actualOfficeAddress);
	}
}
