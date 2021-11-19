package com.insurance.Insurance_spring.domain.dao;


import com.insurance.Insurance_spring.domain.insurance.Approve;

public class ApproveDaoImpl extends Dao implements ApproveDao{
	
	public ApproveDaoImpl() {
		try {
			super.connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void create(Approve approve) {
		String query = "insert into approve ( insuranceID, approved, permissionDate, permissionRefuse, insuranceProblem ) values ( " +
				approve.getInsuranceID() + ", " +
				approve.getApproved() + ", " +
				" '" + approve.getPermissionDate()+ "', " +
				" '" + approve.getPermissionRefuse()+ "', " +
				" '" + approve.getInsuranceProblem() + "')";
		try {
			this.execute(query);

			System.out.println("approve �Ϸ�");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Approve retrieveByInsuranceID(int insuranceID) {
		return null;
		
	}

}
