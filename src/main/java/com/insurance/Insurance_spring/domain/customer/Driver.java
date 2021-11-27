package com.insurance.Insurance_spring.domain.customer;

public class Driver {
	private String licenseNum,carPurpose;
	private int driverID;

	public Driver(){}
	// getter & setter
	public int getDriverID() { return driverID; }
	public void setDriverID(int driverID) { this.driverID = driverID; }
	public String getLicenseNum() {return licenseNum;}
	public void setLicenseNum(String licenseNum) {	this.licenseNum = licenseNum;	}
	public String getCarPurpose() {	return carPurpose;}
	public void setCarPurpose(String carPurpose) {this.carPurpose = carPurpose;	}
	public void finalize() throws Throwable {}

}