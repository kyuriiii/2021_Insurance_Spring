package com.insurance.Insurance_spring.domain.dao;


import com.insurance.Insurance_spring.domain.reward.RewardInfo;

public class DamageDaoImpl extends Dao implements DamageDao{
	
	public DamageDaoImpl() {
		try {
			super.connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}@Override
	public void create(RewardInfo rewardInfo) {
		String query = "insert into damageAssess ( accidentID, employeeID, payment, reason ) values ( " +
						+ rewardInfo.getAccidentID()  + ", " +
						" '" + rewardInfo.getEmployeeID() + "', " +
						" '" + rewardInfo.getPayment()+ "', " +
						" '" + rewardInfo.getReason()+  "' )";
		try {
			this.execute(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public RewardInfo retrieve() {
		return null;
	}
	@Override
	public void update(RewardInfo rewardInfo) {
		
	}

}
