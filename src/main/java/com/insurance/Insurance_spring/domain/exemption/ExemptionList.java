package com.insurance.Insurance_spring.domain.exemption;

import java.util.ArrayList;

public interface ExemptionList {
	public boolean add(Exemption exemption);
	public boolean delete(int accidentNum);
	public Exemption search(int accidentNum);
	public ArrayList<Exemption> getExemptionList();
}
