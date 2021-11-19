package com.insurance.Insurance_spring.domain.dao;


import com.insurance.Insurance_spring.domain.customer.Customer;
import com.insurance.Insurance_spring.domain.customer.CustomerList;
import com.insurance.Insurance_spring.domain.customer.CustomerListImpl;

import java.sql.ResultSet;

public class CustomerDaoImpl extends Dao implements CustomerDao{
	
	//������ : throws �ϱ� ������ try/catch �ϱ�
	public CustomerDaoImpl() {
		try {
			super.connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public int create(Customer customer) {
		String query = "insert into customer ( pCustomerID, address, customerNumber, eMail, job, sex ) values ( " +
				customer.getPCustomerID() + ", " +
				" '" + customer.getAddress() + "', " +
				" '" + customer.getCustomerNumber()+ "', " +
				" '" + customer.geteMail()+ "', " +
				" '" + customer.getJob() + "', " + 
				" '" + customer.getSex() + "' )";
		
		int customerID = 0;
		try {
			this.execute(query);
			
			query = "select LAST_INSERT_ID() as ID";

			ResultSet resultSet = this.retrieve(query);
			
			while ( resultSet.next()) {
				customerID = resultSet.getInt("ID");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return customerID;
	}

	@Override
	public CustomerList retrieve() {
		String query = "select * from customer inner join pcustomer on customer.pCustomerID = pcustomer.pcustomerID";
		CustomerList customerList = new CustomerListImpl();
		
		try {
			ResultSet resultSet = this.retrieve(query);
			
			while ( resultSet.next()) {
				Customer customer = new Customer();
				customer.setCustomerID(resultSet.getInt("customerID"));
				customer.setPCustomerID(resultSet.getInt("pCustomerID"));
				customer.setAddress(resultSet.getString("address"));
				customer.setCustomerNumber(resultSet.getString("customerNumber"));
				customer.seteMail(resultSet.getString("eMail"));
				customer.setJob(resultSet.getString("job"));
				customer.setSex(resultSet.getString("sex"));
				customer.setCustomerName(resultSet.getString("pcustomerName"));
				customer.setPhoneNumber(resultSet.getString("phoneNumber"));
				customer.setDate(resultSet.getString("acceptedDate"));
				customer.setConsultContext(resultSet.getString("consultContext"));
				
				customerList.add(customer);
			}
			
			return customerList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Customer retrieveByID(int ID) {
		return null;
	}
	
	@Override
	public void deleteByID(int ID) {
		
	}

	@Override
	public void updateID(int ID, Customer customer) {
		
	}

}
