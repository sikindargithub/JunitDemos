package com.trailapp.model;

public class Employee {
	private String employeeName;
	private Integer employeeId;
	private Address address;
	
	public Employee() {
		super();
	}
	public Employee(String employeeName, Integer employeeId, Address address) {
		super();
		this.employeeName = employeeName;
		this.employeeId = employeeId;
		this.address = address;
	}
	

}
