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
@Table(name = "employeeDB")
@Access(value = AccessType.FIELD)
public class Employee implements Serializable {
	private static final long serialVersionUID = 292988353596143039L;

	/** The id. */
	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "uid", updatable = false, nullable = false)
	private int employeeId;

	/** The name. */
	@Column(name = "name")
	private String employeeName;
}
