package com.insurance.Insurance_spring.domain.reward;


public class RewardInfo {
	private String payment, reason;
	private int accidentID;
	private int employeeID;
	
	public String getPayment() { return payment; 	}
	public void setPayment(String payment) {	this.payment = payment; }
	public String getReason() { return reason; }
	public void setReason(String reason) { this.reason = reason; }

	public int getAccidentID() {
		return accidentID;
	}

	public void setAccidentID(int accidentID) {
		this.accidentID = accidentID;
	}

	public int getEmployeeID() {	return employeeID;	}
	public void setEmployeeID(int employeeID) {	this.employeeID = employeeID;	}
	
}
