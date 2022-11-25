package com.zoomint.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CarManagerJuniorTest  {

	
	enum Fuel {DIESEL, UNLEADED, HYBRID, ELECTRIC};
	
	private Car createCar(int carId, long horsePower,  Car.Fuel fuel) {
		Car car = new Car();
		car.setCarId(carId);
		car.setHorsePower(horsePower);
		car.setCarFuel(fuel);
		return car;
	}
	
	@Test
	public void test() throws SQLException {
		CarManagerJunior car = new CarManagerJunior();
		List<Car> carga = new ArrayList<Car>();
		carga.add(createCar(11, 1000, Car.Fuel.DIESEL));
		carga.add(createCar(11, 1001, Car.Fuel.HYBRID));
		carga.add(createCar(12, 1000, Car.Fuel.HYBRID));
		carga.add(createCar(13, 1500, Car.Fuel.ELECTRIC));
		carga.add(createCar(14, 2500, Car.Fuel.UNLEADED));
		car.addCarsToMyGarage(carga);
	}

 
}