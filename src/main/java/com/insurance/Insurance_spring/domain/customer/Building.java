package com.insurance.Insurance_spring.domain.customer;

public class Building {
	private int buildingHeight, buildingYear, buildingSize; // m����, �ٴڸ��� m^2����
	private String buildingPrice, buildingOutWall;
	
	public Building(){	}
	public void finalize() throws Throwable {	}
	// getter & setter
	public int getBuildingHeight() {return buildingHeight;}
	public void setBuildingHeight(int buildingHeight) {	this.buildingHeight = buildingHeight;}
	public String getBuildingPrice() {return buildingPrice;}
	public void setBuildingPrice(String buildingPrice) {this.buildingPrice = buildingPrice;}
	public int getBuildingSize() {	return buildingSize;}
	public void setBuildingSize(int buildingSize) {	this.buildingSize = buildingSize;}
	public int getBuildingYear() {return buildingYear;}
	public void setBuildingYear(int buildingYear) {	this.buildingYear = buildingYear;}
	public String getBuildingOutWall() { return buildingOutWall; }
	public void setBuildingOutWall(String buildingOutWall) { this.buildingOutWall = buildingOutWall; }
}