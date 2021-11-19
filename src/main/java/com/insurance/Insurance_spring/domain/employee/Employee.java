package com.insurance.Insurance_spring.domain.employee;

public class Employee {
	private int EmployeeID;
	private String name;
	public Employee() {}
	public Employee(int id) {this.EmployeeID = id;}
	public int getEmployeeID() {	return EmployeeID;	}
	public void setEmployeeID(int employeeID) {	EmployeeID = employeeID;	}
	public String getName() {	return name;	}
	public void setName(String name) {		this.name = name;	}
	}
