package com.purbarun.hibernate.dto;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name = "EmployeeDB")
public class Employee {
	
	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "eid", updatable = false, nullable = false)
	private int id;

	@Column(name = "name", nullable = false)
	private String userName;
	
	@Embedded
	private Address homeAddress;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "street",column = @Column(name="office_street")),
		@AttributeOverride(name = "city",column = @Column(name="office_city")),
		@AttributeOverride(name = "state",column = @Column(name="office_State")),
		@AttributeOverride(name = "pincode",column = @Column(name="office_pincode")),
	})
	private Address officeAddress;
}
