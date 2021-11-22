package com.insurance.Insurance_spring.domain.insurance;

import lombok.Data;

@Data
public class Insurance {
	// Attributes
	private String insuranceName, Contents, insuranceType,insuranceCost;
	private int insuranceID;
	private float achieveRatio;

	// composition
	public Coverage m_hcoverage;
	public Coverage m_mcoverage;
	public Coverage m_lcoverage;
	public Approve m_approve;
	public SaleRecord m_saleRecord;

	public Insurance(){
		// composition
		this.m_hcoverage = new Coverage();
		this.m_mcoverage = new Coverage();
		this.m_lcoverage = new Coverage();
		this.m_approve = new Approve();
		this.m_saleRecord = new SaleRecord();
	}
	public String getContents() {return Contents;}
	public void setContents(String contents) {Contents = contents;}
	public String getInsuranceCost() {	return insuranceCost;}
	public void setInsuranceCost(String insuranceCost) {this.insuranceCost = insuranceCost;}
	public int getInsuranceID() {return insuranceID;}
	public void setInsuranceID(int insuranceID) {this.insuranceID = insuranceID;}
	public String getInsuranceName() {	return insuranceName;	}
	public void setInsuranceName(String insuranceName) {this.insuranceName = insuranceName;	}
	public String getInsuranceType() {return insuranceType;	}
	public void setInsuranceType(String insuranceType) {	this.insuranceType = insuranceType;	}
	public float getAchieveRatio() { return achieveRatio; }
	public void setAchieveRatio(float achieveRatio) { this.achieveRatio = achieveRatio; }

	public Coverage getM_hcoverage() { return m_hcoverage; }
	public void setM_hcoverage(Coverage m_hcoverage) { this.m_hcoverage = m_hcoverage; }
	public Coverage getM_mcoverage() { return m_mcoverage; }
	public void setM_mcoverage(Coverage m_mcoverage) { this.m_mcoverage = m_mcoverage; }
	public Coverage getM_lcoverage() { return m_lcoverage; }
	public void setM_lcoverage(Coverage m_lcoverage) { this.m_lcoverage = m_lcoverage; }
	public Approve getM_approve() { return m_approve; }
	public void setM_approve(Approve m_approve) { this.m_approve = m_approve; }
	public SaleRecord getM_SaleRecord() { return m_saleRecord; }
	public void setM_SaleRecord(SaleRecord m_saleRecord) { this.m_saleRecord = m_saleRecord; }


}