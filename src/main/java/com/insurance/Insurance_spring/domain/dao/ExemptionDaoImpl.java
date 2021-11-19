package com.insurance.Insurance_spring.domain.dao;


import com.insurance.Insurance_spring.domain.accident.Accident;
import com.insurance.Insurance_spring.domain.exemption.Exemption;
import com.insurance.Insurance_spring.domain.exemption.ExemptionList;
import com.insurance.Insurance_spring.domain.exemption.ExemptionListImpl;

import java.sql.ResultSet;

public class ExemptionDaoImpl extends Dao implements ExemptionDao{
	public ExemptionDaoImpl() {
		try {
			super.connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void create(Exemption exemption) {
		String query = "insert into exemption ( accidentID, subFile, reason, legacy ) values ( " +
				exemption.getAccidentID() + ", " +
				" '" + exemption.getSubFile() + "', " +
				" '" + exemption.getReason()+ "', " +
				" '" + exemption.getLegacy()+  "' )";
		
		try {
			this.execute(query);
			
			query = "select LAST_INSERT_ID() as ID";

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void deleteAll() {
	}
	@Override
	public void deleteByID(int ID) {
	}
	public ExemptionList retrieve() {
		String query = "select * from exemption";
		ExemptionList exemptionList = new ExemptionListImpl();
		try {
			ResultSet resultSet = this.retrieve(query);
			
			while ( resultSet.next()) {
				Exemption exemption = new Exemption();
				exemption.setAccidentID(resultSet.getInt("accidentID"));
				exemption.setExemptionID(resultSet.getInt("exemptionID"));
				exemption.setSubFile(resultSet.getInt("subFile"));
				exemption.setReason(resultSet.getString("reason"));
				exemption.setLegacy(resultSet.getString("legacy"));
				
				exemptionList.add(exemption);
			}
			return exemptionList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public void update(int state, Accident accident) {
	}
	@Override
	public ExemptionList retrieveList() {
		String query = "select * from accident left join accidentInfo on accidentInfo.accidentID = accident.accidentID left join exemption on exemption.accidentID = accident.accidentID  where accidentInfo.judged = 0  ";
		ExemptionList accidentList = new ExemptionListImpl();
		try {
			ResultSet resultSet = this.retrieve(query);
			
			while ( resultSet.next()) {
				Exemption exemption = new Exemption();
				exemption.setAccidentID(resultSet.getInt("accidentID"));
				exemption.setAccidentDate(resultSet.getString("accidentDate"));
				exemption.setSubFile(resultSet.getInt("subFile"));
				exemption.setReason(resultSet.getString("reason"));
				exemption.setLegacy(resultSet.getString("legacy"));
				exemption.setCustomerID(resultSet.getInt("customerID"));
				accidentList.add(exemption);
			}
			return accidentList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
