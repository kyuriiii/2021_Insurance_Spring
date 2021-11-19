package com.insurance.Insurance_spring.domain.dao;


import com.insurance.Insurance_spring.domain.insurance.Coverage;

public interface CoverageDao {
	//������ �������̽� ����
	public int create(Coverage coverage);
	public Coverage retrieveByID( int coverageID );

}
