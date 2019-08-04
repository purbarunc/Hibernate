package com.purbarun.hibernate.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "CityDB")
@Data
@NamedQueries({
	@NamedQuery(name = "City_FindById", query = "from City where id=:id"),
	@NamedQuery(name = "City_GetAll", query = "from City")
})
public class City {
	@Id
	@Column(name = "cityid")
	private int id;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "city")
	private String name;

	@Override
	public String toString() {
		return "City [id=" + id + ", state=" + state + ", name=" + name + "]";
	}
}
