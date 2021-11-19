package com.insurance.Insurance_spring.domain.dao;


import com.insurance.Insurance_spring.domain.customer.Driver;

public interface DriverDao {
	//������ �������̽� ����
	public void create(Driver driver, int customerID);
	public Driver retrieveByID( int driverID );

}
