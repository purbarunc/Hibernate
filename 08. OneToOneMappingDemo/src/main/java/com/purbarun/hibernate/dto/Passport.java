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
@Table(name = "Passport")
public class Passport {
	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "pid")
	@Getter
	private int id;
	
	@Getter
	@Setter
	@Column(name = "place_of_issue")
	private String placeOfIssue;

	@Override
	public String toString() {
		return "Passport [id=" + id + ", placeOfIssue=" + placeOfIssue + "]";
	}
}
