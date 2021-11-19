package com.insurance.Insurance_spring.domain.dao;


import com.insurance.Insurance_spring.domain.accident.Accident;
import com.insurance.Insurance_spring.domain.exemption.Exemption;
import com.insurance.Insurance_spring.domain.exemption.ExemptionList;

public interface ExemptionDao {
	public void create(Exemption exemption);
	public void deleteAll();
	public void deleteByID(int ID);
	public ExemptionList retrieve();
	public void update(int state, Accident accident);
	public ExemptionList retrieveList();
}
