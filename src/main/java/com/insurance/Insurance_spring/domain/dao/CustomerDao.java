package com.insurance.Insurance_spring.domain.dao;


import com.insurance.Insurance_spring.domain.customer.Customer;
import com.insurance.Insurance_spring.domain.customer.CustomerList;

public interface CustomerDao {
	public int create(Customer customer);
	public void deleteByID(int ID);
	public Customer retrieveByID(int ID);
	public CustomerList retrieve();
	public void updateID(int ID,Customer customer);
}
