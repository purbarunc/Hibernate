package com.purbarun.hibernate.dao;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.purbarun.hibernate.dto.Course;
import com.purbarun.hibernate.dto.Student;

@TestMethodOrder(OrderAnnotation.class)
class StudentDaoTest {
	StudentDao dao;

	@BeforeEach
	void createDaoObject() {
		dao = new StudentDao();
	}

	@Test
	@Order(1)
	void createTest() {
		Course course1 = new Course();
		course1.setName("Spring Core");
		Course course2 = new Course();
		course2.setName("Java");
		Course course3 = new Course();
		course3.setName("Python");

		Student student1 = new Student();
		student1.setName("Arun");
		Student student2 = new Student();
		student2.setName("Vikas");
		Student student3 = new Student();
		student3.setName("Rahul");

		Set<Course> student1Courses = new HashSet<Course>();
		student1Courses.add(course1);
		student1Courses.add(course3);

		Set<Course> student2Courses = new HashSet<Course>();
		student2Courses.add(course2);
		student2Courses.add(course3);

		Set<Course> student3Courses = new HashSet<Course>();
		student3Courses.add(course1);
		student3Courses.add(course2);
		student3Courses.add(course3);

		/**************************************/
		/* Relating all Students with Courses */
		/**************************************/

		student1.setCourses(student1Courses);
		student2.setCourses(student2Courses);
		student3.setCourses(student3Courses);

		StudentDao dao = new StudentDao();
		dao.saveStudent(student1);
		dao.saveStudent(student2);
		dao.saveStudent(student3);
	}

	@Test
	@Order(2)
	void readTest() {
		Student student=dao.findById(3);
		Set<Course> courses=student.getCourses();
		System.out.println("Courses");
		for (Course course : courses) {
			System.out.println(course.getName());
		}
	}
}
