package com.trailapp.model;

public class Address {
	String city;
	String zipcode;
	public Address() {
		super();
	}
	public Address(String city, String zipcode) {
		super();
		this.city = city;
		this.zipcode = zipcode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	@Override
	public String toString() {
		return "Address [city=" + city + ", zipcode=" + zipcode + "]";
	}

}
