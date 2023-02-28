package com.carrentalapp.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.carrentalapp.dao.CarRentalDaoImpl;
import com.carrentalapp.dao.ICarRentalDao;
import com.carrentalapp.exceptions.CarNotFoundException;
import com.carrentalapp.exceptions.CustomerNotFoundException;
import com.carrentalapp.model.Car;
import com.carrentalapp.model.Booking;

public class CarRentalServiceImpl implements ICarRentalService {

	ICarRentalDao carRentalDao = new CarRentalDaoImpl();
	public void addCar(Car car) {
		carRentalDao.addCar(car);
	}

	public boolean deleteCar(int carNumber) throws CarNotFoundException {
		boolean  val = carRentalDao.deleteCar(carNumber);
		if(!val)
			throw new CarNotFoundException("The car with given "+carNumber+" is not available...");
		return val;
	}

	public boolean updateCar(int carNumber, double pricePerHour) throws CarNotFoundException {
		boolean val = carRentalDao.updateCar(carNumber, pricePerHour);
		if(!val)
			throw new CarNotFoundException("The car with given "+carNumber+" is not available...");
		return val;
	}

	public List<Car> getAllCars() {
		List<Car> cars =  carRentalDao.findAllCars();
		return cars;
	}

	public List<Car> getByBrandAndSeats(String brand, int noOfSeats) throws CarNotFoundException {
		List<Car> carsByBrandAndSeats = carRentalDao.findByBrandAndSeats(brand, noOfSeats);
		if(carsByBrandAndSeats.isEmpty())
			throw new CarNotFoundException("The car list by given "+ brand+" and "+noOfSeats+" is not available... ");
		return carsByBrandAndSeats.stream().sorted((Comparator.comparing(Car::getBrand))).collect(Collectors.toList());
	}

	public List<Car> getByMileage(int mileage) throws CarNotFoundException {
		List<Car> carsByMileage = carRentalDao.findByMileage(mileage);
		if(carsByMileage.isEmpty())
			throw new CarNotFoundException("The car list by given "+mileage+" is not available... ");
		return carsByMileage.stream().sorted((Comparator.comparing(Car::getMileage))).collect(Collectors.toList());
	}

	public List<Car> getByPricePerHour(double pricePerHour) throws CarNotFoundException {
		List<Car> carsByPrice = carRentalDao.findByPricePerHour(pricePerHour);
		if(carsByPrice.isEmpty())
			throw new CarNotFoundException("The car list by given "+pricePerHour+" is not available... ");
		return carsByPrice.stream().sorted((Comparator.comparing(Car::getPricePerHour))).collect(Collectors.toList());
	}

	
	
	

}
