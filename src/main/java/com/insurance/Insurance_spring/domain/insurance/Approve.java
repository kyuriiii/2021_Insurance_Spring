package com.insurance.Insurance_spring.domain.insurance;

public class Approve {
	private String permissionDate, permissionRefuse, insuranceProblem;
	private int insuranceID, approveID;
	private int approved; //0�̸� ������ ��, 1�̸� ����
	
	public Approve(){}

	public int getApproveID() { return approveID; }
	public void setApproveID(int approveID) { this.approveID = approveID; }
	public int getInsuranceID() { return insuranceID; }
	public void setInsuranceID(int insuranceID) { this.insuranceID = insuranceID; }
	public int getApproved() { return approved; }
	public void setApproved(int approved) { this.approved = approved; }
	public String getPermissionDate() {return permissionDate;}
	public void setPermissionDate(String permissionDate) {this.permissionDate = permissionDate;}
	public String getPermissionRefuse() {return permissionRefuse;}
	public void setPermissionRefuse(String permissionRefuse) {this.permissionRefuse = permissionRefuse;}
	public String getInsuranceProblem() {return insuranceProblem;}
	public void setInsuranceProblem(String insuranceProblem) {this.insuranceProblem = insuranceProblem;}
}
