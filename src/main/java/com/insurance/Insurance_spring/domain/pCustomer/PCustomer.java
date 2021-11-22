package com.insurance.Insurance_spring.domain.pCustomer;

import lombok.Data;

@Data
public class PCustomer {
	private int pcustomerID;
	private String customerName, consultContext, phoneNumber, date;
	
	public PCustomer(){ }
	public String getConsultContext() { return consultContext; }
	public void setConsultContext(String consultContext) { this.consultContext = consultContext; }
	public int getPCustomerID() { return pcustomerID; }
	public void setPCustomerID(int pcustomerID) { this.pcustomerID = pcustomerID; }
	public String getCustomerName() { return customerName; }
	public void setCustomerName(String customerName) { this.customerName = customerName; }
	public String getPhoneNumber() { return phoneNumber; }
	public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
	public String getDate() { return date; }
	public void setDate( String date ) { this.date = date; }
}