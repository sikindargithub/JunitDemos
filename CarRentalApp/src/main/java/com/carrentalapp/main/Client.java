package com.carrentalapp.main;

import java.util.Scanner;

import com.carrentalapp.exceptions.CarNotFoundException;
import com.carrentalapp.service.CarRentalServiceImpl;
import com.carrentalapp.service.ICarRentalService;

public class Client {
	private static String  str = null;
	public static void main(String[] args) {
		ICarRentalService carRentalService = new CarRentalServiceImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to car rental app...");
		System.out.println("Do you want to continue : Yes/No");
		String str = sc.next();
		do {
			System.out.println("Enter \"1\" to get all cars list : ");
			System.out.println("Enter \"2\" to get cars list  by brand and no of seats : ");
			System.out.println("Enter \"3\" to get cars list by mileage : ");
			System.out.println("Enter \"4\" to get cars list by below price per hour : ");
			int num = sc.nextInt();
			switch(num) {
			case 1:
				carRentalService.getAllCars().forEach((car)->{
					
					System.out.println("Car number : "+car.getCarNumber()+", Brand : "+car.getBrand()+", Model : "+car.getModel()+
										", Mileage : "+car.getMileage()+", No of seats : "+car.getNoOfSeats()+", Price/hour :"+car.getPricePerHour()
										);
					
				});
				System.out.println("Do you want to continue : Yes/No");
				str = sc.next();
				if(str.equalsIgnoreCase("No"))
				break;
				break;
			case 2:
				System.out.println("Enter brand : ");
				String brand = sc.next();
				System.out.println("Enter no of seats : ");
				int noOfSeats = sc.nextInt();
				try {
					carRentalService.getByBrandAndSeats(brand, noOfSeats).forEach(car->{
						System.out.println(car);
						
					});
				} catch (CarNotFoundException e) {
					System.out.println(e.getMessage());
				}
				System.out.println("Do you want to continue : Yes/No");
				str = sc.next();
				if(str.equalsIgnoreCase("No"))
				break;
				break;
			case 3:
				System.out.println("Enter mileage : ");
				int mileage = sc.nextInt();
				try {
					carRentalService.getByMileage(mileage).forEach(car->{
						System.out.println(car);
						
					});
				} catch (CarNotFoundException e) {
					System.out.println(e.getMessage());
				}
				System.out.println("Do you want to continue : Yes/No");
				str = sc.next();
				if(str.equalsIgnoreCase("No"))
				break;
				break;
			case 4:
				System.out.println("Enter price/hour : ");
				double pricePerHour = sc.nextDouble();
				try {
					carRentalService.getByPricePerHour(pricePerHour).forEach(car->{
						System.out.println(car);
						
					});
				} catch (CarNotFoundException e) {
					System.out.println(e.getMessage());
				}
				System.out.println("Do you want to continue : Yes/No");
				str = sc.next();
				if(str.equalsIgnoreCase("No"))
				break;
				break;
			default :
				System.out.println("Invalid input...");
			}
		}while(str.equalsIgnoreCase("Yes"));
		System.out.println("Thank you for using the application...");
	}

}
