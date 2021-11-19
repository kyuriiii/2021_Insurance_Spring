package com.insurance.Insurance_spring.domain.dao;


import com.insurance.Insurance_spring.domain.insurance.Coverage;

import java.sql.ResultSet;

public class CoverageDaoImpl extends Dao implements CoverageDao{
	
	public CoverageDaoImpl() {
		try {
			super.connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int create(Coverage coverage) {
		String query = "insert into coverage (  insuranceID, coverageCondition, coverageContent, coverageCost ) values ( " +
				coverage.getInsuranceID() + ", " +
				" '" + coverage.getCoverageCondition() + "', " +
				" '" + coverage.getCoverageContent()+ "', " +
				" '" + coverage.getCoverageCost()+ "')";
		
		int coverageID = 0;
		try {
			this.execute(query);
			
			query = "select LAST_INSERT_ID() as ID";

			ResultSet resultSet = this.retrieve(query);
			
			while ( resultSet.next()) {
				coverageID = resultSet.getInt("ID");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return coverageID;
	}
	@Override
	public Coverage retrieveByID(int coverageID) {
		
		return null;
	}

}
