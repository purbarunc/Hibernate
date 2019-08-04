package com.purbarun.hibernate.dto;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "CourseDB")
public class Course {
	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "courseid")
	@Getter
	private int courseId;
	
	@Column(name = "name")
	@Getter
	@Setter
	private String name;
	
	@ManyToMany(mappedBy = "courses")
	@Getter
	@Setter
	private Set<Student> students;

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", name=" + name + ", students=" + students + "]";
	}	
}
