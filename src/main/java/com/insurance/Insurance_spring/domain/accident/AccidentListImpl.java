package com.insurance.Insurance_spring.domain.accident;

import java.util.ArrayList;

public class AccidentListImpl implements AccidentList {

	private ArrayList<Accident> accidentList;
	public AccidentListImpl() {
		this.accidentList = new ArrayList<Accident>();
	}
	public boolean add(Accident accident){	
		if(this.accidentList.add(accident)) return true;
		else return false;
		}
	public boolean delete(int accidentNum){	
		for(Accident accident : this.accidentList) {
			if(accident.getAccidentID() == accidentNum) {
				if(this.accidentList.remove(accident)) return true;
				break;
			}
		}
		return false;
	}
	public Accident search(int accidentNum){	
		for(Accident accident : this.accidentList) {
			if(accident.getAccidentID() == accidentNum) return accident;
		}
		return null;
	}
	public int getNexID() { return this.getAccidentList().size() + 1; }
	public ArrayList<Accident> getAccidentList() {	return accidentList;}
	public void setAccidentList(ArrayList<Accident> accidentList) {	this.accidentList = accidentList;	}
	
}