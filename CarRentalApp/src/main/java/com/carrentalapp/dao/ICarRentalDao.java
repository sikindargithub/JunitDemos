package com.carrentalapp.dao;

import java.util.List;
import com.carrentalapp.model.Car;


public interface ICarRentalDao {

	// for adding cars and changing details
	void addCar(Car car);
	boolean deleteCar(int carNumber);
	boolean updateCar(int carNumber,double pricePerHour);
	
	
	// called by Client
	List<Car> findAllCars();
	List<Car> findByBrandAndSeats(String brand,int noOfSeats);
	List<Car> findByMileage(int mileage);
	List<Car> findByPricePerHour(double pricePerHour);


}
