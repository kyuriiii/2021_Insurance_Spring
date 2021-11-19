package com.insurance.Insurance_spring.domain.dao;


import com.insurance.Insurance_spring.domain.pCustomer.PCustomer;
import com.insurance.Insurance_spring.domain.pCustomer.PCustomerList;

public interface PCustomerDao {
	public void create(PCustomer pcustomer);
	public void deleteByID(int ID);
	public PCustomer retrieveByID(int ID);
	public PCustomerList retrieve();
	public void updateID(int ID,PCustomer pCustomer);

}
