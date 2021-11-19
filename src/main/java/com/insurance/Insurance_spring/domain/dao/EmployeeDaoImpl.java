package com.insurance.Insurance_spring.domain.dao;


import com.insurance.Insurance_spring.domain.employee.Employee;
import com.insurance.Insurance_spring.domain.employee.EmployeeList;
import com.insurance.Insurance_spring.domain.employee.EmployeeListImpl;

import java.sql.ResultSet;

public class EmployeeDaoImpl extends Dao implements EmployeeDao{
	public EmployeeDaoImpl() {
		try {
			super.connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public EmployeeList retrieve() {
		String query = "select * from employee";
		EmployeeList employeeList = new EmployeeListImpl();
		try {
			ResultSet resultSet = this.retrieve(query);
			while ( resultSet.next()) {
				Employee employee = new Employee();
				employee.setEmployeeID(resultSet.getInt("employeeID"));
				employee.setName(resultSet.getString("employeeName"));
				
				employeeList.add(employee);
			}
			return employeeList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
