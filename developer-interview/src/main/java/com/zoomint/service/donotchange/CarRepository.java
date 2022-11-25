package com.zoomint.service.donotchange;

import com.zoomint.service.Car;

import java.sql.SQLException;
import java.util.List;


/**
 *  DO NOT CHANGE THIS CLASS
 *
 */


public interface CarRepository {

	/**
	 * Saves car to database and assigns id to returned object.
	 *
	 * @param newCar with parameters to be saved
	 * @return newCar with database ID
	 */
	Car save(Car newCar) throws SQLException;

	/** Searches for all cars that are owned.
	 *
	 * @return Empty list if nothing is found or list of all cars.
	 */

	List<Car> findAllCarsInGarage() throws SQLException;

	/** Deletes car by it primary key - carId.
	 *
	 * @param carId car with this ID will be deleted.
	 * @return Number of cars deleted.
	 */

	int delete(int carId) throws SQLException;


}
