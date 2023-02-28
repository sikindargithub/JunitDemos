package com.carrentalapp.model;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Booking {
	
	private Integer bookingId;
	private String name;
	private String gender;
	private LocalDate date;
	private Time time;
	private long phoneNo;
	private boolean isPaymentDone;
	private int noOfDays;
	private double totalCost;
	private Integer carNumber;
	public Booking() {
		super();
	}
	public Booking(Integer bookingId, String name, String gender, LocalDate date, Time time, long phoneNo,
			boolean isPaymentDone, int noOfDays, double totalCost, Integer carNumber) {
		super();
		this.bookingId = bookingId;
		this.name = name;
		this.gender = gender;
		this.date = date;
		this.time = time;
		this.phoneNo = phoneNo;
		this.isPaymentDone = isPaymentDone;
		this.noOfDays = noOfDays;
		this.totalCost = totalCost;
		this.carNumber = carNumber;
	}
	public Integer getBookingId() {
		return bookingId;
	}
	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public boolean isPaymentDone() {
		return isPaymentDone;
	}
	public void setPaymentDone(boolean isPaymentDone) {
		this.isPaymentDone = isPaymentDone;
	}
	public int getNoOfDays() {
		return noOfDays;
	}
	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	public Integer getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(Integer carNumber) {
		this.carNumber = carNumber;
	}
	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", name=" + name + ", gender=" + gender + ", date=" + date
				+ ", time=" + time + ", phoneNo=" + phoneNo + ", isPaymentDone=" + isPaymentDone + ", noOfDays="
				+ noOfDays + ", totalCost=" + totalCost + ", carNumber=" + carNumber + "]";
	}
	
	
	

}
