package com.insurance.Insurance_spring.domain.dao;


import com.insurance.Insurance_spring.domain.contract.Contract;
import com.insurance.Insurance_spring.domain.contract.ContractList;

public interface ContractDao {
	public int create(Contract contract);
	public void deleteByID(int ID);
	public Contract retrieveByID(int ID);
	public ContractList retrieve();
	public void updateID(int ID,Contract contract);
	public void updateIDCustomer( Contract contract );
}
