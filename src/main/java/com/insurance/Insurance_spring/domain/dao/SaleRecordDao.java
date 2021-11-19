package com.insurance.Insurance_spring.domain.dao;


import com.insurance.Insurance_spring.domain.insurance.SaleRecord;

public interface SaleRecordDao {
	public void create(SaleRecord saleRecord);
	public SaleRecord retrieve( int insuranceID );
}
