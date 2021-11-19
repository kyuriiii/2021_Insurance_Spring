package com.insurance.Insurance_spring.domain.dao;


import com.insurance.Insurance_spring.domain.customer.Driver;

public class DriverDaoImpl extends Dao implements DriverDao{
	
	public DriverDaoImpl() {
		try {
			super.connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void create(Driver driver, int customerID) {
		String query = "insert into driverinfo ( customerID, licenseNum, carPurpose ) values ( " +
				customerID + ", " +
				" '" + driver.getLicenseNum() + "', " +
				" '" + driver.getCarPurpose()+ "' )";

		try {
			this.execute(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public Driver retrieveByID(int driverID) {
		
		return null;
	}

}
