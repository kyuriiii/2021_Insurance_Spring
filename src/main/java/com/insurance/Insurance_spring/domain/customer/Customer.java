package com.insurance.Insurance_spring.domain.customer;


import com.insurance.Insurance_spring.domain.accident.Accident;
import com.insurance.Insurance_spring.domain.pCustomer.PCustomer;

import java.util.ArrayList;

public class Customer extends PCustomer {

	private int customerID;
	private String address,customerNumber,eMail,job,sex,fileHref;
	private ArrayList<Accident> accidents;
	// composition
	private Building m_building;
	private Car m_car;
	private Driver m_driver;

	public Customer(){
		super();
		this.accidents = new ArrayList<Accident>();
		this.m_building = new Building();
		this.m_car = new Car();
		this.m_driver = new Driver();
	}
	// getter & setter
	public int getCustomerID() {return customerID;}
	public void setCustomerID(int customerID) {this.customerID = customerID;}
	public String getAddress() {return address;}
	public void setAddress(String address) {this.address = address;}
	public String getCustomerNumber() {return customerNumber;}
	public void setCustomerNumber(String customerNumber) {this.customerNumber = customerNumber;}
	public String geteMail() {	return eMail;}
	public void seteMail(String eMail) {this.eMail = eMail;}
	public String getJob() {return job;}
	public void setJob(String job) {this.job = job;}
	public Building getM_building() {return m_building;}
	public void setM_building(Building m_building) {this.m_building = m_building;}
	public Car getM_car() {	return m_car;}
	public void setM_car(Car m_car) {this.m_car = m_car;	}
	public Driver getM_driver() {return m_driver;	}
	public void setM_driver(Driver m_driver) {this.m_driver = m_driver;	}
	public String getSex() {return sex;	}
	public void setSex(String string) {this.sex = string;}
	public String getFileHref() {return fileHref;	}
	public void setFileHref(String fileHref) {this.fileHref = fileHref;}
	// �߰�
	public ArrayList<Accident> getAccident() {	return accidents;}
	public void setAccident(Accident accident) {this.accidents.add(accident);}
}