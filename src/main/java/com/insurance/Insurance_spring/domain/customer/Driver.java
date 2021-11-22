package com.insurance.Insurance_spring.domain.customer;

import lombok.Data;

@Data
public class Driver {
	private String licenseNum,carPurpose;

	public Driver(){}
	// getter & setter
	public String getLicenseNum() {return licenseNum;}
	public void setLicenseNum(String licenseNum) {	this.licenseNum = licenseNum;	}
	public String getCarPurpose() {	return carPurpose;}
	public void setCarPurpose(String carPurpose) {this.carPurpose = carPurpose;	}
	public void finalize() throws Throwable {}

}