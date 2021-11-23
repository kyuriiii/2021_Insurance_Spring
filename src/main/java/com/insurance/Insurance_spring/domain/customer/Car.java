package com.insurance.Insurance_spring.domain.customer;

public class Car {

	private String carNumber,carType;
	private int carPrice,own; // 0�� ��, 1�� ��

	public Car(){	}
	// getter & setter
	public String getCarNumber() {return carNumber;}
	public void setCarNumber(String carNumber) {	this.carNumber = carNumber;}
	public int isOwn() {return own;	}
	public void setOwn(int own) {this.own = own;}
	public String getCarType() {return carType;}
	public void setCarType(String carType) {this.carType = carType;}
	public int getCarPrice() {	return carPrice;}
	public void setCarPrice(int carPrice) {this.carPrice = carPrice;}

	public void finalize() throws Throwable {	}

}