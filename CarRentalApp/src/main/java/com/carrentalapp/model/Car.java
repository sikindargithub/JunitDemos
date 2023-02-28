package com.carrentalapp.model;

public class Car {
	
	private Integer carNumber;
	private String brand;
	private String model;
	private int mileage;
	private int noOfSeats;
	private double pricePerHour;
	
	public Car() {
		super();
	}
	public Car(Integer carNumber, String brand, String model, int mileage, int noOfSeats, double pricePerHour) {
		super();
		this.carNumber = carNumber;
		this.brand = brand;
		this.model = model;
		this.mileage = mileage;
		this.noOfSeats = noOfSeats;
		this.pricePerHour = pricePerHour;
	}
	public Integer getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(Integer carNumber) {
		this.carNumber = carNumber;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	public int getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	public double getPricePerHour() {
		return pricePerHour;
	}
	public void setPricePerHour(double pricePerHour) {
		this.pricePerHour = pricePerHour;
	}
	@Override
	public String toString() {
		return "Car [carNumber=" + carNumber + ", brand=" + brand + ", model=" + model + ", mileage=" + mileage
				+ ", noOfSeats=" + noOfSeats + ", pricePerHour=" + pricePerHour + "]";
	}
	

}
