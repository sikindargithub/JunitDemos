package com.acheron.training;

public class Calculator {
	
	public int add(int a,int b) {
		System.out.println("Sum :");
		int sum = a+b;
		
		return sum;
	}
	public int product(int a,int b) {
		
		System.out.println("Product :");
		int prod = a*b;
		return prod;
	}
	public double difference(int a,int b) {
		
		System.out.println("Difference :");
		double diff = a-b;
		return diff;
	}
	
	public String greetUser(String name) {
		
		return "Welcome "+name.toUpperCase();
	}

}
