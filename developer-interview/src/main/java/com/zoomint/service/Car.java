package com.zoomint.service;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

public class Car {

	enum Fuel {DIESEL, UNLEADED, HYBRID, ELECTRIC};

	@Id
	@SequenceGenerator(name="car_seq")
	int carId;


	@Column(name = "engine_power")
	long horsePower;

	@Column(name = "engine_fuel")
	Fuel carFuel;


	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public long getHorsePower() {
		return horsePower;
	}

	public void setHorsePower(long horsePower) {
		this.horsePower = horsePower;
	}

	public Fuel getCarFuel() {
		return carFuel;
	}

	public void setCarFuel(Fuel carFuel) {
		this.carFuel = carFuel;
	}
}
