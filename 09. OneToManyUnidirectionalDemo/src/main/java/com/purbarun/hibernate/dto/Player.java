package com.purbarun.hibernate.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PlayerDB")
public class Player {
	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "playerid")
	@Getter
	@Setter
	private int id;
	
	@Column(name = "name")
	@Getter
	@Setter
	private String name;
	
	@Column(name = "Nation")
	@Getter
	@Setter
	private String nationality;

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", nationality=" + nationality + "]";
	}	
}
