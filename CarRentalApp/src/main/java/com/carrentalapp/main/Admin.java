package com.carrentalapp.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.sql.Date;

import com.carrentalapp.dao.ConnectionUtil;
import com.carrentalapp.exceptions.CarNotFoundException;
import com.carrentalapp.exceptions.CustomerNotFoundException;
import com.carrentalapp.model.Car;
import com.carrentalapp.model.Booking;
import com.carrentalapp.service.CarRentalServiceImpl;
import com.carrentalapp.service.BookingServiceImpl;
import com.carrentalapp.service.ICarRentalService;
import com.carrentalapp.util.AllQueries;
import com.carrentalapp.service.IBookingService;

public class Admin {

	public static Connection connection = null;
	public static double price;
	private static String  str = null;
	public static void main(String[] args) {
		ICarRentalService carService = new CarRentalServiceImpl();
		IBookingService bookingService = new BookingServiceImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to car rental app...");
		System.out.println("Do you want to continue : Yes/No");
		String str= sc.next();
		do {
			
			if(str.equalsIgnoreCase("No"))
				break;
			// For cars
			System.out.println("Enter \"1\" to add cars : ");
			System.out.println("Enter \"2\" to delete car : ");
			System.out.println("Enter \"3\" to update car : ");
			// For booking
			System.out.println("Enter \"4\" to add booking car : ");
			System.out.println("Enter \"5\" to get bookings by booking id : ");
			System.out.println("Enter \"6\" to get bookings list by date : ");
			System.out.println("Enter \"7\" to get bookings list by payment status : ");
			int number = sc.nextInt();
			switch (number) {
			case 1:
				System.out.println("Enter car number : ");
				int carNumber = sc.nextInt();
				System.out.println("Enter brand : ");
				String brand = sc.next();
				System.out.println("Enter model : ");
				String model = sc.next();
				System.out.println("Enter mileage : ");
				int mileage = sc.nextInt();
				System.out.println("Enter no of seats : ");
				int noOfSeats = sc.nextInt();
				System.out.println("Enter price per hour :");
				int pricePerHour = sc.nextInt();
				carService.addCar(new Car(carNumber, brand, model, mileage, noOfSeats, pricePerHour));
				System.out.println("Do you want to continue : Yes/No");
				str = sc.next();
				if(str.equalsIgnoreCase("No"))
				break;
				break;
			case 2:
				System.out.println("Enter car number : ");
				int carNumber1 = sc.nextInt();
				try {
					boolean val = carService.deleteCar(carNumber1);
					if(val)
						System.out.println("Deleted successfully...");
					
						
				} catch (CarNotFoundException e) {
					System.out.println(e.getMessage());
				}
				System.out.println("Do you want to continue : Yes/No");
				str= sc.next();
				if(str.equalsIgnoreCase("No"))
				break;
				break;
			case 3:
				System.out.println("Enter car number : ");
				int carNumber2 = sc.nextInt();
				System.out.println("Enter price per hour :");
				double pricePerHour2 = sc.nextDouble();
				try {
					boolean val = carService.updateCar(carNumber2, pricePerHour2);
					if(val)
						System.out.println("Updated successfully...");
				} catch (CarNotFoundException e) {
					System.out.println(e.getMessage());
				}
				System.out.println("Do you want to continue : Yes/No");
				str = sc.next();
				if(str.equalsIgnoreCase("No"))
				break;
				break;
			case 4:
				System.out.println("Enter booking id :");
				int bookingId = sc.nextInt();
				System.out.println("Enter name : ");
				String name = sc.next();
				System.out.println("Enter gender : ");
				String gender = sc.next();
				System.out.println("Enter date in \'yyyy-mm-dd\' format :");
				String date = sc.next();
				LocalDate date2 = LocalDate.parse(date);
				System.out.println("Enter time in \'hh:mm:ss\' format:");
				String strTime = sc.next();
				Time time1 = Time.valueOf(strTime);
				System.out.println("Enter phone no : ");
				long phoneNo = sc.nextLong();
				System.out.println("Enter payment done status : true/false");
				boolean isPaymentDone = sc.nextBoolean();
				System.out.println("Enter no of days do you want to book for : ");
				int noOfDays = sc.nextInt();
				System.out.println("Enter car number : ");
				int carNumber3 = sc.nextInt();
				bookingService.rentCar(new Booking(bookingId, name, gender, date2,time1, phoneNo, isPaymentDone, noOfDays,
						 0.0,carNumber3), carNumber3);
				System.out.println("Do you want to continue : Yes/No");
				str = sc.next();
				if(str.equalsIgnoreCase("No"))
				break;
				break;
			case 5:
				System.out.println("Enter booking id : ");
				int bookingId1 = sc.nextInt();

				try {
					System.out.println(bookingService.getById(bookingId1));
				} catch (CustomerNotFoundException e) {
					System.out.println(e.getMessage());
				}
				System.out.println("Do you want to continue : Yes/No");
				str = sc.next();
				if(str.equalsIgnoreCase("No"))
				break;
				break;
			case 6:
				System.out.println("Enter date in \'yyyy-mm-dd\' format: ");
				String strDate = sc.next();
				LocalDate date4 = LocalDate.parse(strDate);
				try {
					bookingService.getByDate(date4).forEach(System.out::println);
				} catch (CustomerNotFoundException e) {
					System.out.println(e.getMessage());
				}
				System.out.println("Do you want to continue : Yes/No");
				str = sc.next();
				if(str.equalsIgnoreCase("No"))
				break;
				break;
			case 7:
				System.out.println("Enter payment done status :true/false ");
				boolean isPaymentDone1 = sc.nextBoolean();

				try {
					bookingService.getByIsPaymentDone(isPaymentDone1).forEach(System.out::println);
				} catch (CustomerNotFoundException e) {
					System.out.println(e.getMessage());
				}
				System.out.println("Do you want to continue : Yes/No");
				str = sc.next();
				if(str.equalsIgnoreCase("No"))
				break;
				break;
			default:
				System.out.println("Invalid input...");
			}
		} while (str.equalsIgnoreCase("Yes"));
		System.out.println("Thank you for using the application..");

	}

}
