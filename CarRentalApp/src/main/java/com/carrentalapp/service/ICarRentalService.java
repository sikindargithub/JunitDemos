package com.carrentalapp.service;

import java.util.List;

import com.carrentalapp.exceptions.CarNotFoundException;
import com.carrentalapp.exceptions.CustomerNotFoundException;
import com.carrentalapp.model.Car;
import com.carrentalapp.model.Booking;

public interface ICarRentalService {
	
	// called by Admin
	void addCar(Car car);
	boolean deleteCar(int carNumber) throws CarNotFoundException;
	boolean updateCar(int carNumber,double pricePerHour) throws CarNotFoundException;
	
	// called by Client
	List<Car> getAllCars();
	List<Car> getByBrandAndSeats(String brand,int noOfSeats) throws CarNotFoundException;
	List<Car> getByMileage(int mileage) throws CarNotFoundException;
	List<Car> getByPricePerHour(double pricePerHour) throws CarNotFoundException;

}
