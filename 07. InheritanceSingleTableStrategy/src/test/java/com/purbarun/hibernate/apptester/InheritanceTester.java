package com.purbarun.hibernate.apptester;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.purbarun.hibernate.dao.UniversalDao;
import com.purbarun.hibernate.dto.FourWheeler;
import com.purbarun.hibernate.dto.TwoWheeler;
import com.purbarun.hibernate.dto.Vehicle;

@DisplayName("Testing Inheritence for Hibernate")
class InheritanceTester {

	@Test
	@DisplayName("Save Test")
	void createtest() {
		UniversalDao<Vehicle> vehicledao = new UniversalDao<>(Vehicle.class);
		UniversalDao<TwoWheeler> twoWheelerdao = new UniversalDao<>(TwoWheeler.class);
		UniversalDao<FourWheeler> fourWheelerdao = new UniversalDao<>(FourWheeler.class);

		Vehicle vehicle = new Vehicle();
		vehicle.setName("myvehicle");

		TwoWheeler twoWheeler = new TwoWheeler();
		twoWheeler.setName("Bike");
		twoWheeler.setTwoWheelerSteering("Bike Steering Handle");

		FourWheeler fourWheeler = new FourWheeler();
		fourWheeler.setName("Alto");
		fourWheeler.setFourWheelerSteering("Alto Steering Wheel");

		vehicledao.save(vehicle);
		twoWheelerdao.save(twoWheeler);
		fourWheelerdao.save(fourWheeler);
	}
}
