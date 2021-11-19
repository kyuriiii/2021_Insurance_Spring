package com.insurance.Insurance_spring.domain.dao;


import com.insurance.Insurance_spring.domain.customer.Building;

public interface BuildingDao {
	//������ �������̽� ����
	public void create(Building building, int customerID);
	public Building retrieveByID( int buildingID );

}
