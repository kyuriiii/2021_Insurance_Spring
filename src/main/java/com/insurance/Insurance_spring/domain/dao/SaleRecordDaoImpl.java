package com.insurance.Insurance_spring.domain.dao;


import com.insurance.Insurance_spring.domain.insurance.SaleRecord;

public class SaleRecordDaoImpl extends Dao implements SaleRecordDao{
	
	public SaleRecordDaoImpl() {
		try {
			super.connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void create(SaleRecord saleRecord) {
		String query = "insert into salerecord ( insuranceID, goalCnt, saleCnt ) values ( " +
				saleRecord.getInsuranceID() + ", " +
				saleRecord.getGoalCnt() + ", " +
				saleRecord.getSaleCnt() + ")";

		try {
			this.execute(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public SaleRecord retrieve( int insuranceID ) {
		return null;
	}
	
	
}
