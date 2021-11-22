package com.insurance.Insurance_spring.domain.pCustomer;

import java.util.ArrayList;

public class PCustomerListImpl implements PCustomerList {

	private ArrayList<PCustomer> pCustomerList;

	public PCustomerListImpl() {
		this.pCustomerList = new ArrayList<PCustomer>();
	}

	public boolean add(PCustomer pCustomer){
		if(this.pCustomerList.add(pCustomer)) return true;	
		else return false;
	}

	public boolean delete(int customerID){
		for(PCustomer pCustomer : this.pCustomerList) {
			if(pCustomer.getPCustomerID() == customerID) {
				if(this.pCustomerList.remove(pCustomer)) return true;
				break;
			}
		}
		return false;
	}

	public PCustomer search(int customerID){
		for(PCustomer customer : this.pCustomerList) {
			if(customer.getPCustomerID() == customerID) return customer;
		}
		return null;
	}

	public boolean update(PCustomer pCustomer, int customerID){
		for(PCustomer uCustomer : this.pCustomerList) {
			if(uCustomer.getPCustomerID() == customerID) {
				uCustomer.setPcustomerName(pCustomer.getPcustomerName());
				uCustomer.setPhoneNumber(pCustomer.getPhoneNumber());
			}
		}
		return false;
	}
	public ArrayList<PCustomer> getCustomerList() {
		return pCustomerList;
	}
	public void setCustomerList(ArrayList<PCustomer> pCustomerList) {
		this.pCustomerList = pCustomerList;
	}
	
}