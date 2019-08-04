package com.purbarun.hibernate.dto;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Data
@Table(name = "students")
@Access(value = AccessType.FIELD)
public class Student implements Serializable {
	private static final long serialVersionUID = 2535938404300987982L;

	/** The id. */
	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "uid", updatable = false, nullable = false)
	private int studentId;

	/** The name. */
	@Column(name = "name")
	private String studentName;

}
