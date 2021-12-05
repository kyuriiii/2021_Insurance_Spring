package com.insurance.Insurance_spring.domain.customer;

import java.util.ArrayList;

/**
 * @author User
 * @version 1.0
 * @created 02-5-2021 ���� 10:32:56
 */
public interface CustomerList {

	public boolean add(Customer customer);
	public boolean delete(int customerID);
	public Customer search(int customerID);
	public boolean search(Customer customer);
	public boolean update(Customer customer, int customerID);
	public ArrayList<Customer> getCustomerList();
	public void setCustomerList(ArrayList<Customer> customerList);

}