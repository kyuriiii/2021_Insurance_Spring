package com.insurance.Insurance_spring.domain.exemption;


import com.insurance.Insurance_spring.domain.accident.Accident;

public class Exemption extends Accident {
	private int exemptionID, subFile, customerID;
	private String reason, legacy;
	public int getExemptionID() {return exemptionID;	}
	public void setExemptionID(int exemptionID) {	this.exemptionID = exemptionID;	}
	public String getReason() {	return reason;	}
	public void setReason(String reason) {	this.reason = reason;	}
	public int getSubFile() {	return subFile;	}
	public void setSubFile(int subFile) {	this.subFile = subFile;	}
	public String getLegacy() {	return legacy;	}
	public void setLegacy(String legacy) {	this.legacy = legacy;	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	
}
