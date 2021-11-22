package com.insurance.Insurance_spring.domain.insurance;

import lombok.Data;

@Data
public class SaleRecord {
	private int insuranceID, goalCnt, saleCnt;
	
	public int getInsuranceID() {return insuranceID;	}
	public void setInsuranceID(int insuranceID) {this.insuranceID = insuranceID;}
	public int getGoalCnt() {return goalCnt;	}
	public void setGoalCnt(int goalCnt) {this.goalCnt = goalCnt;	}
	public int getSaleCnt() {return saleCnt;	}
	public void setSaleCnt(int saleCnt) {this.saleCnt = saleCnt;	}
}
