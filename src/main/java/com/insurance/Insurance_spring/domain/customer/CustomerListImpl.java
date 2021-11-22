package com.insurance.Insurance_spring.domain.customer;

import java.util.ArrayList;

/**
 * @author User
 * @version 1.0
 * @created 02-5-2021 ���� 10:32:56
 */

public class CustomerListImpl implements CustomerList {
	// attributes
	private ArrayList<Customer> customerList;
	
	public CustomerListImpl() {
		this.customerList = new ArrayList<Customer>();
	}
	
	// getter & setter
	public ArrayList<Customer> getCustomerList() {return customerList;}
	public void setCustomerList(ArrayList<Customer> customerList) {	this.customerList = customerList;}
	
	public void finalize() throws Throwable {	}
	public boolean add(Customer customer){
		if(this.customerList.add(customer)) return true;	
		else return false;
	}
	public boolean delete(int customerID){
		for(Customer customer : this.customerList) {
			if(customer.getCustomerID() == customerID) {
				if(this.customerList.remove(customer)) return true;
				break;
			}
		}
		return false;
	}
	public Customer search(int customerID){
		for(Customer customer : this.customerList) {
			if(customer.getCustomerID() == customerID) return customer;
		}
		return null;
	}
	public Customer search(Customer customer ) {
		for(Customer scustomer : this.customerList) {
			if(scustomer.getPcustomerName().equals( customer.getPcustomerName() ) && scustomer.getCustomerNumber().equals( customer.getCustomerNumber() )) return scustomer;
		}
		return null;
	}
	public boolean update(Customer customer, int customerID){
		for(Customer uCustomer : this.customerList) {
			if(uCustomer.getCustomerID() == customerID) {
				uCustomer.setPcustomerName(customer.getPcustomerName());
				uCustomer.setPhoneNumber(customer.getPhoneNumber());
			}
		}
		return false;
	}
}