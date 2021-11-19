package com.insurance.Insurance_spring.domain.dao;


import com.insurance.Insurance_spring.domain.pCustomer.PCustomer;
import com.insurance.Insurance_spring.domain.pCustomer.PCustomerList;
import com.insurance.Insurance_spring.domain.pCustomer.PCustomerListImpl;

import java.sql.ResultSet;

public class PCustomerDaoImpl extends Dao implements PCustomerDao {

	public PCustomerDaoImpl() {
		try {
			super.connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void create(PCustomer pcustomer) {
		String query = "insert into pcustomer ( pcustomerName, phoneNumber, acceptedDate, consultContext ) values ( " +
				" '" + pcustomer.getCustomerName() + "', " +
				" '" + pcustomer.getPhoneNumber()+ "', " +
				" '" + pcustomer.getDate()+ "', " +
				" '" + pcustomer.getConsultContext() + "')";
		try {
			this.execute(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteByID( int ID ) {
		String query = "delete from pcustomer where pcustomerID = " + ID;
		try {
			this.execute(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public PCustomerList retrieve() {
		String query = "select * from pcustomer where consultContext = ''";
		PCustomerList pCustomerList = new PCustomerListImpl();
		
		try {
			ResultSet resultSet = this.retrieve(query);
			
			while ( resultSet.next()) {
				PCustomer pCustomer = new PCustomer();
				pCustomer.setPCustomerID(resultSet.getInt("pcustomerID"));
				pCustomer.setCustomerName(resultSet.getString("pcustomerName"));
				pCustomer.setPhoneNumber(resultSet.getString("phoneNumber"));
				pCustomer.setDate(resultSet.getString("acceptedDate"));
				pCustomer.setConsultContext(resultSet.getString("consultContext"));
				pCustomerList.add(pCustomer);
			}
			
			return pCustomerList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public PCustomer retrieveByID( int ID ){
		String query = "select * from pcustomer where pCustomerID = " + ID + " limit 1";
		
		try {
			ResultSet resultSet = this.retrieve(query);
			PCustomer pCustomer = new PCustomer();
			
			while ( resultSet.next()) {
				pCustomer.setPCustomerID(resultSet.getInt("pcustomerID"));
				pCustomer.setCustomerName(resultSet.getString("pcustomerName"));
				pCustomer.setPhoneNumber(resultSet.getString("phoneNumber"));
				pCustomer.setDate(resultSet.getString("acceptedDate"));
				pCustomer.setConsultContext(resultSet.getString("consultContext"));
			}
			
			return pCustomer;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void updateID( int ID, PCustomer pCustomer ) {
		String query = "update pcustomer set " +
				"pcustomerName = '" + pCustomer.getCustomerName() + "', " +
				"phoneNumber = '" + pCustomer.getPhoneNumber() + "', " + 
				"acceptedDate = '" + pCustomer.getDate() + "', " +
				"consultContext = '" + pCustomer.getConsultContext() + "' " + 
				"where pcustomerID = " + ID;
		try {
			this.execute(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
