package com.purbarun.hibernate.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "CityDB")
@Data
@NamedNativeQueries({
	@NamedNativeQuery(name = "City_FindById", query = "select * from citydb where cityid=:id",resultClass = City.class),
	@NamedNativeQuery(name = "City_GetAll", query = "select * from citydb",resultClass = City.class)
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
