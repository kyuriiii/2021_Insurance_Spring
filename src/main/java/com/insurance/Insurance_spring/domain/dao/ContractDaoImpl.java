package com.insurance.Insurance_spring.domain.dao;


import com.insurance.Insurance_spring.domain.contract.Contract;
import com.insurance.Insurance_spring.domain.contract.ContractList;
import com.insurance.Insurance_spring.domain.contract.ContractListImpl;
import com.insurance.Insurance_spring.domain.customer.Customer;
import com.insurance.Insurance_spring.domain.insurance.Insurance;

import java.sql.ResultSet;

public class ContractDaoImpl extends Dao implements ContractDao{
	
	public ContractDaoImpl() {
		try {
			super.connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int create(Contract contract) {
		String query = "insert into contract ( customerID, insuranceID, startDate, price, endDate, insuranceRatio ) values ( " +
				contract.getCustomer().getCustomerID() + ", " +
				contract.getInsurance().getInsuranceID() + ", " +
				" '" + contract.getDate() + "', " +
				" '" + contract.getPrice()+ "', " +
				" '" + contract.getEndDate() + "', " + 
				" '" + contract.getInsuranceRatio() + "' )";
		
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
	public void deleteByID(int ID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Contract retrieveByID(int ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContractList retrieve() {
		String query = "select * from contract inner join customer using(customerID) inner join insurance using(insuranceID) inner join pcustomer using(pcustomerID)";
		ContractList contractList = new ContractListImpl();
		
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
				customer.setPcustomerName(resultSet.getString("pcustomerName"));
				customer.setPhoneNumber(resultSet.getString("phoneNumber"));
				customer.setAcceptedDate(resultSet.getString("acceptedDate"));
				customer.setConsultContext(resultSet.getString("consultContext"));
				
				Insurance insurance = new Insurance();
				insurance.setInsuranceID(resultSet.getInt("insuranceID"));
				insurance.setInsuranceName(resultSet.getString("insuranceName"));
				insurance.setInsuranceType(resultSet.getString("type"));
				insurance.setInsuranceCost(resultSet.getString("insuranceCost"));
				insurance.setContents(resultSet.getString("content"));
				
				Contract contract = new Contract();
				contract.setContractID(resultSet.getInt("contractID"));
				contract.setDate(resultSet.getString("startDate"));
				contract.setPrice(resultSet.getInt("price"));
				contract.setEndDate(resultSet.getString("endDate"));
				contract.setInsuranceRatio(resultSet.getFloat("insuranceRatio"));
				contract.setCustomer(customer);
				contract.setInsurance(insurance);
				
				contractList.add(contract);
			}
			
			return contractList;
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	return null;
	}

	@Override
	public void updateID(int ID, Contract contract) {
		String query = "update contract set " +
				"endDate = '" + contract.getEndDate() + "' " + 
				"where contractID = " + ID;
		try {
			this.execute(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateIDCustomer(Contract contract) {
		String query = "update pcustomer set " +
	            "pcustomerName = '" + contract.getCustomer().getPcustomerName() + "', " +
	            "phoneNumber = '" + contract.getCustomer().getPhoneNumber() + "' " + 
	            "where pcustomerID = " + contract.getCustomer().getPCustomerID();
		try {
			this.execute(query);
			
			query = "update customer set " +
					"address = '" + contract.getCustomer().getAddress() + "', " +
					"job = '" + contract.getCustomer().getJob() + "' " +
					"where customerID = " + contract.getCustomer().getCustomerID();

			this.execute(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
