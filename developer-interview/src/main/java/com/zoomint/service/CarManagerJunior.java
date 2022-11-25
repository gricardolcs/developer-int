package com.zoomint.service;

import com.zoomint.service.donotchange.CarRepository;

import javax.annotation.Resource;

import java.sql.SQLException;
import java.util.List;


/**
 * Imagine you have to do code review on this (only this) class. You know, that your colleague  who wrote this code had to
 * fulfill following story:
 * Me as rich person, I want to collect cars. There are coming offers with cars which I can park to my garage. I don`t care
 * about their price, I only want add cars which are more powerful (more horse powers) and if offered cars have same power (equal horsepower), I want only more
 * ecologic car than I already own (substitute), which means that DIESEL < UNLEADED < HYBRID < ELECTRIC where best is ELECTRIC, worst is DIESEL.
 * Garage has unlimited size.
 *
 * As result of action I would like to get list of cars that were added to my garage.
 * <p/>
 * You can see several problems in the code so you will write comments to lines, where some problem may occur, but your colleague don`t believe in you,
 * so you have to convince him by writing unit tests for each bug which is there.
 * <p/>
 * You can use anything online, but you cant contact anybody.
 * <p/>
 * Tasks:   1) Add comments to lines with possible problem.
 *          2) Write tests that will fail on this wrong implementation.
 * <p/>
 * You may use any library, but you cant change classes in donotchange package (spring files, maven pom can be modified).
 */

public class CarManagerJunior {

	@Resource  // this is same as @Inject, @Autowire
	private CarRepository carRepository;


	//DO NOT MODIFY THIS CODE, just write comments
	// I think that not have a good performance and, I believe that meed to do some change:
	// Is recomended use the Stream API to do:
	// 1. the filter between the possibleCars and the ownedCars.
	// 2. use the comparator inside the stream.
	// 3. User a ForEach.
	// 4. that no sound good delete and save, why you will delete an element if it exists? just maybe update
	// 5. in the Line 50, if the list came empty may throw an exception, is needed work with empty result.
	// 6. Line 52 53 is no good, I recomend use Stream a for Stream for each 
	// 7. Line 55, 56 use a stream fitler
	// 8. line 59 - 60 is not good and not clearly in the case when you work with exists records in the table. I the case that you want save a record
	//        and it's ready exists wil throw an roolback.
	// 9. line 65 return and empty list, may is good return a value or mensaje


	public List<Car> addCarsToMyGarage(List<Car> possibleCars) throws SQLException {

		List<Car> ownedCars = carRepository.findAllCarsInGarage();
		for (Car possibleCar : possibleCars) {
			for (Car ownedCar : ownedCars) {
				if (possibleCar.horsePower < ownedCar.horsePower
						|| isMoreEcologic(possibleCar, ownedCar)) {

					carRepository.delete(possibleCar.carId);
					carRepository.save(possibleCar);

				} else {
					possibleCars.remove(possibleCar);
				}
			}
		}
		return possibleCars;

	}

	private boolean isMoreEcologic(Car possibleCar, Car ownedCar) {
		return possibleCar.carFuel.compareTo(ownedCar.carFuel) > 0;
	}
}
