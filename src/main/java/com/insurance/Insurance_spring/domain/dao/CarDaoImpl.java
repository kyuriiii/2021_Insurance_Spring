package com.insurance.Insurance_spring.domain.dao;


import com.insurance.Insurance_spring.domain.customer.Car;

public class CarDaoImpl extends Dao implements CarDao{
	
	public CarDaoImpl() {
		try {
			super.connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void create(Car car, int customerID) {
		String query = "insert into carinfo ( customerID, carType, own, carNumber, carPrice ) values ( " +
				customerID + ", " +
				" '" + car.getCarType() + "', " +
				" '" + car.isOwn()+ "', " +
				" '" + car.getCarNum()+ "', " +
				" '" + car.getCarPrice() + "')";

		try {
			this.execute(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public Car retrieveByID(int carID) {
		
		return null;
	}

}
