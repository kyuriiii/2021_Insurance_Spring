package com.insurance.Insurance_spring.domain.dao;


import com.insurance.Insurance_spring.domain.customer.Car;

public interface CarDao {
	//������ �������̽� ����
	public void create(Car car, int customerID);
	public Car retrieveByID( int carID );

}
