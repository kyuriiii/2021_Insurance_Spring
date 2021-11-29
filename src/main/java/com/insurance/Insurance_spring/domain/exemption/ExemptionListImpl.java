package com.insurance.Insurance_spring.domain.exemption;
import java.util.ArrayList;

public class ExemptionListImpl implements ExemptionList{
	// attributes
	private ArrayList<Exemption> exemptionList;
	
	public ExemptionListImpl() {
		this.exemptionList = new ArrayList<Exemption>();
	}
	@Override
	public boolean add(Exemption exemption) {
		if(this.exemptionList.add(exemption)) return true;	
		else return false;
	}

	@Override
	public boolean delete(int accidentNum) {
		for(Exemption exemption : this.exemptionList) {
			if(exemption.getAccidentID() == accidentNum) {
				if(this.exemptionList.remove(exemption)) return true;
				break;
			}
		}
		return false;
	}

	@Override
	public Exemption search(int accidentNum) {
		for(Exemption exemption : this.exemptionList) {
			if(exemption.getAccidentID() == accidentNum) return exemption;
		}
		return null;
	}

	@Override
	public ArrayList<Exemption> getExemptionList() {
		return this.exemptionList;
	}
	public void setExemptionList(ArrayList<Exemption> exemptionList) {
		this.exemptionList = exemptionList;
	}

}
