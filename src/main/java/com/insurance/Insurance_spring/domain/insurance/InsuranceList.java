package com.insurance.Insurance_spring.domain.insurance;

import java.util.ArrayList;

/**
 * @author User
 * @version 1.0
 * @created 02-5-2021 ���� 10:32:56
 */
public interface InsuranceList {

	public boolean add(Insurance insurance);
	public boolean delete(int insuranceId);
	public Insurance search(int insuranceId);
	public ArrayList<Insurance> getInsuranceList();

}