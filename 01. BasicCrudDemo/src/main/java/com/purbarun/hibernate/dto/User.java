package com.purbarun.hibernate.dto;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usertbl")
@Access(value = AccessType.PROPERTY)
public class User {
	private int id;
	private String name;

	public User() {
	}

	public User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Id
	@Column(name = "uid")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", name=" + name + "]";
	}

}
