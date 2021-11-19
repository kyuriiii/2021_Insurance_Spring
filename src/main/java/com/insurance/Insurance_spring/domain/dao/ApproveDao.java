package com.insurance.Insurance_spring.domain.dao;


import com.insurance.Insurance_spring.domain.insurance.Approve;

public interface ApproveDao {
	public void create(Approve approve);
	public Approve retrieveByInsuranceID( int insuranceID );

}
