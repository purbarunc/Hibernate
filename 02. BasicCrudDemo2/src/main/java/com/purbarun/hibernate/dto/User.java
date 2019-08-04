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

/**
 * DTO(Data Transfer Object) Class for User Entity. This Class is mapped to the
 * Relational Database through annotations provided in the Java Persistence API.
 * Here ID is auto generated through another special annotation. In this DTO I
 * have used Field Access to map the Entities which is the best best practice.
 * Additionally I have used Project Lombok throughout the project which is a
 * tool to generate the getters and setters without actually coding them and to
 * eliminate the boilerplate code.
 * 
 * @author Purbarun Chakrabarti
 *
 */

@Entity
@Data
@Table(name = "usertbl")
@Access(value = AccessType.FIELD)
public class User implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5727234595664473551L;

	/** The id. */
	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "uid", updatable = false, nullable = false)
	private int id;

	/** The name. */
	@Column(name = "name")
	private String name;

}
