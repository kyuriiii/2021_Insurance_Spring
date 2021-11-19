package com.insurance.Insurance_spring.domain.employee;
import java.util.ArrayList;

public class EmployeeListImpl implements EmployeeList {
	private ArrayList<Employee> employeeList;
	public EmployeeListImpl() {
		this.employeeList = new ArrayList<Employee>();
	}
	public boolean add(Employee employee){	
		if(this.employeeList.add(employee)) return true;
		else return false;
		}
	public boolean delete(int employeeID){	
		for(Employee employee : this.employeeList) {
			if(employee.getEmployeeID() == employeeID) {
				if(this.employeeList.remove(employee)) return true;
				break;
			}
		}
		return false;
	}
	public Employee search(int employeeID){	
		for(Employee employee : this.employeeList) {
			if(employee.getEmployeeID() == employeeID) return employee;
		}
		return null;
	}
	public ArrayList<Employee> getEmployeeList() { return employeeList;}
	public void setEmployeeList(ArrayList<Employee> employeeList) {	this.employeeList = employeeList;	}
}
