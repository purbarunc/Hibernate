package com.purbarun.hibernate.apptester;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.purbarun.hibernate.dao.UniversalDao;
import com.purbarun.hibernate.dto.Employee;
import com.purbarun.hibernate.dto.Student;

@DisplayName("UniversalDao Under Test")
class UniversalDaoTest {
	UniversalDao<Employee> employeeDao;
	UniversalDao<Student> studentDao;

	@BeforeEach
	void createDaoObjects() {
		employeeDao = new UniversalDao<>(Employee.class);
		studentDao = new UniversalDao<>(Student.class);
	}

	@Nested
	@DisplayName("Testing for Employee Entity")
	@TestMethodOrder(OrderAnnotation.class)
	class EmployeeTest {
		@Test
		@DisplayName("Save New Employee Test")
		@Order(1)
		void createTest() {
			Employee emp = new Employee();
			emp.setEmployeeName("Sachin");
			employeeDao.save(emp);
		}

		@Test
		@DisplayName("Find Employee by Id Test")
		@Order(2)
		void readTest() {
			Employee emp = employeeDao.findById(1);
			assertEquals(emp.getEmployeeName(), "Sachin");
		}

		@Test
		@DisplayName("Update Employee by Id Test")
		@Order(3)
		void updateTest() {
			Employee emp = new Employee();
			emp.setEmployeeId(1);
			emp.setEmployeeName("Saurav");
			employeeDao.update(emp);
		}

		@Test
		@DisplayName("Delete Employee by Id Test")
		@Order(4)
		void deleteTest() {
			employeeDao.deleteById(1);
		}
	}

	@Nested
	@DisplayName("Testing for Student Entity")
	@TestMethodOrder(OrderAnnotation.class)
	class StudentTest {
		@Test
		@DisplayName("Save New Student Test")
		@Order(5)
		void createTest() {
			Student student = new Student();
			student.setStudentName("Rajiv");
			studentDao.save(student);
		}

		@Test
		@DisplayName("Find Student by Id Test")
		@Order(6)
		void readTest() {
			Student student = studentDao.findById(1);
			assertEquals(student.getStudentName(), "Rajiv");
		}

		@Test
		@DisplayName("Update Student by Id Test")
		@Order(7)
		void updateTest() {
			Student student = new Student();
			student.setStudentId(1);
			student.setStudentName("Rahul");
			studentDao.update(student);
		}

		@Test
		@DisplayName("Delete Student by Id Test")
		@Order(8)
		void deleteTest() {
			studentDao.deleteById(1);
		}
	}
}
