package com.purbarun.hibernate.dto;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@DiscriminatorValue("Car")
public class FourWheeler extends Vehicle {
	@Column(name = "Steering_type")
	private String fourWheelerSteering;
}
