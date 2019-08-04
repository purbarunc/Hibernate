package com.purbarun.hibernate.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "CityDB")
public class City {
	@Id
	@Column(name = "cityid")
	@Getter
	private int id;
	
	@Column(name = "state")
	@Getter
	@Setter
	private String state;
	
	@Getter
	@Setter
	@Column(name = "city")
	private String name;
}
