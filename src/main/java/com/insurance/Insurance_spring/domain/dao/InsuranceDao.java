package com.insurance.Insurance_spring.domain.dao;


import com.insurance.Insurance_spring.domain.insurance.Insurance;
import com.insurance.Insurance_spring.domain.insurance.InsuranceList;

public interface InsuranceDao {
	//������ �������̽� ����
	public int create(Insurance insurance);
	public void deleteAll();
	public void deleteByName(String name);
	public InsuranceList retrieve();
	public InsuranceList retrieveNoApprove();
	public InsuranceList retrieveApprove();
	public void updateName(String name);

}
