package com.insurance.Insurance_spring.domain.pCustomer;

public class PCustomer {
	private int pcustomerID;
	private String pcustomerName, consultContext, phoneNumber, acceptedDate;
	
	public PCustomer(){ }
	public String getConsultContext() { return consultContext; }
	public void setConsultContext(String consultContext) { this.consultContext = consultContext; }
	public int getPCustomerID() { return pcustomerID; }
	public void setPCustomerID(int pcustomerID) { this.pcustomerID = pcustomerID; }
	public String getPcustomerName() { return pcustomerName; }
	public void setPcustomerName(String pcustomerName) { this.pcustomerName = pcustomerName; }
	public String getPhoneNumber() { return phoneNumber; }
	public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
	public String getAcceptedDate() { return acceptedDate; }
	public void setAcceptedDate(String acceptedDate) { this.acceptedDate = acceptedDate; }
}