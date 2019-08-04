package com.purbarun.hibernate.dto;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "StudentDB")
public class Student {
	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "studentid")
	private int studentId;
	
	@Column(name = "name")
	@Getter
	@Setter
	private String name;
	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "Student_Course", 
        joinColumns = { @JoinColumn(name = "studentId") }, 
        inverseJoinColumns = { @JoinColumn(name = "courseId") }
    )
	@Getter
	@Setter
	private Set<Course> courses;

	@Override
	public String toString() {
		return "Student [stidentId=" + studentId + ", name=" + name + ", courses=" + courses + "]";
	}	
}
