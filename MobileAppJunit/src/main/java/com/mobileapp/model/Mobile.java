package com.mobileapp.model;

public class Mobile {
	int mobileId;
	String model;
	String brand;
	double price;
	public Mobile() {
		super();
	}
	public Mobile(int mobileId,  String brand,String model, double price) {
		super();
		this.mobileId = mobileId;
		this.model = model;
		this.brand = brand;
		this.price = price;
	}
	public int getMobileId() {
		return mobileId;
	}
	public void setMobileId(int mobileId) {
		this.mobileId = mobileId;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Mobile [mobileId=" + mobileId + ", model=" + model + ", brand=" + brand + ", price=" + price + "]";
	}
	
	

}
