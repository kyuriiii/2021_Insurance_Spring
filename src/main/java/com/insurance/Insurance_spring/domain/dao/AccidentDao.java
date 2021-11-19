package com.insurance.Insurance_spring.domain.dao;


import com.insurance.Insurance_spring.domain.accident.Accident;
import com.insurance.Insurance_spring.domain.accident.AccidentList;

public interface AccidentDao {
	public int create(Accident accident);
	public void deleteAll();
	public void deleteByID(int ID);
	public AccidentList retrieve();
	public AccidentList retrieveNotCompleted();
	public AccidentList retrievecommpleted(); 
	public int retrieveAccidentCnt(int customerID);
	public void update( Accident accident);
	public void createInfo(Accident accident);
	public void createInvestigation(Accident daccident);
	public void updateJudged(Accident accident);
}
