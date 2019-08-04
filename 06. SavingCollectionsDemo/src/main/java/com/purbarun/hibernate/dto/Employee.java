package com.purbarun.hibernate.dto;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import lombok.Data;

@Data
@Entity
@Table(name = "Employeetbl")
public class Employee {

	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "eid", updatable = false, nullable = false)
	private int id;

	@Column(name = "name", nullable = false)
	private String userName;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@JoinTable(name = "User_Address",joinColumns = @JoinColumn(name="UserId"))
	@GenericGenerator(name = "addresskey", strategy ="increment")
	@CollectionId(columns = { @Column(name = "addressid") }, generator = "addresskey", type = @Type(type = "long"))
	private List<Address> listOfAddresses=new ArrayList<>();
}
