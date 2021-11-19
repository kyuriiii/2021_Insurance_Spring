package com.insurance.Insurance_spring.domain.employee;
import java.util.ArrayList;

public interface EmployeeList {
	public boolean add(Employee employee);
	public boolean delete(int employeeID);
	public Employee search(int employeeID);
	public ArrayList<Employee> getEmployeeList();
}
