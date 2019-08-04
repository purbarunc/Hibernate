package com.purbarun.hibernate.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TeamDB")
public class Team {
	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "teamid")
	@Getter
	private int id;
	
	@Column(name = "name")
	@Getter
	@Setter
	private String name;
	
	@Column(name = "country")
	@Getter
	@Setter
	private String country;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "id")
	@Getter
	@Setter
	private List<Player> player;

	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + ", country=" + country + ", player=" + player + "]";
	}		
}
