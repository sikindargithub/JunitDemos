package com.carrentalapp.util;

public class AllQueries {

	// For adding and updating cars
	public static final String ADDCARQUERY = "insert into car values(?,?,?,?,?,?)";
	public static final String DELETECARQUERY = "delete from car where carNumber = ?";
	public static final String UPDATECARQUERY = "update car set pricePerHour = ? where carNUmber = ?";
	
	// For retrieving cars
	public static final String ALLCARSQUERY = "select * from car";
	public static final String BRANDANDSEATSQUERY = "select * from car where brand = ? and noOfSeats = ?";
	public static final String MILEAGEQUERY = "select * from car where mileage = ?";
	public static final String PRICEQUERY = "select * from car where pricePerHour < ?";
	
	//For adding customers
	public static final String BOOKINGQUERY = "insert into booking values(?,?,?,?,?,?,?,?,?,?) ";
	public static final String IDQUERY = "select * from booking where bookingId = ?";
	public static final String DATEQUERY = "select * from booking where date = ?";
	public static final String PAYMENTQUERY = "select * from booking where isPaymentDone = ?";
	
	//For total cost
	public static final String TOTALCOSTQUERY = "select pricePerHour from car c where c.carNumber =?";
	
	
}
