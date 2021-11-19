package com.insurance.Insurance_spring.domain.insurance;

public class Coverage {
	private String coverageCondition, coverageContent;
	private int coverageCost, coverageID, insuranceID;
	public Coverage(){	}

	public String getCoverageCondition() {	return coverageCondition;	}
	public void setCoverageCondition(String coverageCondition) {	this.coverageCondition = coverageCondition;	}
	public String getCoverageContent() {	return coverageContent;	}
	public void setCoverageContent(String coverageContent) {this.coverageContent = coverageContent;	}
	public int getCoverageCost() {	return coverageCost;	}
	public void setCoverageCost(int coverageCost) {	this.coverageCost = coverageCost;	}

	public int getCoverageID() { return coverageID; }
	public void setCoverageID(int coverageID) { this.coverageID = coverageID; }
	public int getInsuranceID() { return insuranceID; }
	public void setInsuranceID(int insuranceID) { this.insuranceID = insuranceID; }
}