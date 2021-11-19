package com.insurance.Insurance_spring.domain.dao;


import com.insurance.Insurance_spring.domain.accident.Accident;
import com.insurance.Insurance_spring.domain.accident.AccidentList;
import com.insurance.Insurance_spring.domain.accident.AccidentListImpl;
import com.insurance.Insurance_spring.domain.customer.Customer;

import java.sql.ResultSet;


public class AccidentDaoImpl extends Dao implements AccidentDao {

	public AccidentDaoImpl() {
		try {
			super.connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int create(Accident accident) {
		String query = "insert into accident ( accidentSize, accidentType, accidentDate, accidentTime, accidentPlace, customerID ) values ( " +
				 	" '" + accident.getAccidentSize() + "', " +
		            " '" + accident.getAccidentType() + "', " +
		            " '" + accident.getAccidentDate()+ "', " +
		            " '" + accident.getAccidentTime()+ "', " +
		            " '" + accident.getAccidentPlace()+ "', " +
		            " '" + accident.getCustomer().getCustomerID() + "')";
		int accidentID = 0;
		try {
			this.execute(query);

			query = "select LAST_INSERT_ID() as ID";

			ResultSet resultSet = this.retrieve(query);

			while ( resultSet.next()) { accidentID = resultSet.getInt("ID"); }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return accidentID;
	}

	public void deleteAll() {
	}

	public void deleteByID(int ID) {

	}

	public AccidentList retrieve() {
		String query = "select * from accident left join accidentInfo on accidentInfo.accidentID = accident.accidentID left join ainvestigation on ainvestigation.accidentID = accident.accidentID";
		AccidentList accidentList = new AccidentListImpl();
		try {
			ResultSet resultSet = this.retrieve(query);

			while(resultSet.next()) {
				Customer customer = new Customer();
				customer.setCustomerID(resultSet.getInt("customerID"));
				
				Accident accident = new Accident();
				accident.setAccidentID(resultSet.getInt("accidentID"));
				accident.setAccidentSize(resultSet.getString("accidentSize"));
				accident.setAccidentType(resultSet.getString("accidentType"));
				accident.setAccidentDate(resultSet.getString("accidentDate"));
				accident.setAccidentTime(resultSet.getString("accidentTime"));
				accident.setAccidentPlace(resultSet.getString("accidentPlace"));
				accident.setCustomer(customer);
				///
				accident.setAccidentComplete(resultSet.getInt("completed"));
				accident.setJudgementComplete(resultSet.getInt("judged"));
				accident.setDate(resultSet.getString("date"));
				///
				accident.getM_siteInfo().setScenario(resultSet.getString("scenario"));
				accident.getM_siteInfo().setRecord(resultSet.getInt("record"));
				accident.getM_siteInfo().setPhoto(resultSet.getInt("photo"));
				accident.getM_siteInfo().setVideo(resultSet.getInt("video"));
				accident.getM_siteInfo().setDamageScale(resultSet.getString("scale"));
				
				accidentList.add(accident);
			}
			return accidentList;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public void update(Accident accident) { 
				String query = "update accidentInfo set " +
						"completed = '" +  accident.getAccidentComplete() + "' "+
						"where accidentID = " + accident.getAccidentID();
				try {
					this.execute(query);
				} catch (Exception e) {
					e.printStackTrace();
				}
	}

	@Override
	public void createInfo(Accident accident) { // join�� �ؼ� insert�ؾ� �ϴ°ǰ�?
		try {
			String	query = "insert into accidentInfo ( accidentID, completed, judged, date ) values ( " +
						" '" + accident.getAccidentID() + "', " +
						" '" + accident.getAccidentComplete() + "', " +
						" '" + accident.getJudgementComplete() + "', " +
						" '" + accident.getDate()+  "')";
				this.execute(query);
		} catch (Exception e) { e.printStackTrace();}
	}

	@Override
	public void createInvestigation(Accident accident) { // �������� ������ ����
		try {
			String	query = "insert into ainvestigation ( accidentID, scenario, record, video, photo, scale ) values ( " +
						" '" + accident.getAccidentID() + "', " +
						" '" + accident.getM_siteInfo().getScenario() + " ', " +
						" '" + accident.getM_siteInfo().getRecord() + "', " +
						" '" + accident.getM_siteInfo().getVideo() + "', " +
						" '" + accident.getM_siteInfo().getPhoto()+ "', " +
						" '" + accident.getM_siteInfo().getDamageScale()+ "')";
				this.execute(query);
		} catch (Exception e) { e.printStackTrace();}
	}

	@Override
	public void updateJudged(Accident accident) {
		String query = "update accidentInfo set " +
				"judged = '" +  accident.getJudgementComplete() + "' "+
				"where accidentID = " + accident.getAccidentID();
		try {
			this.execute(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public AccidentList retrieveNotCompleted() {
		String query = "select * from accident left join accidentInfo on accidentInfo.accidentID = accident.accidentID where accidentInfo.completed = 1";
		AccidentList accidentList = new AccidentListImpl();
		try {
			ResultSet resultSet = this.retrieve(query);

			while ( resultSet.next()) {
				Customer customer = new Customer();
				customer.setCustomerID(resultSet.getInt("customerID"));
				
				Accident accident = new Accident();
				accident.setAccidentID(resultSet.getInt("accidentID"));
				accident.setAccidentSize(resultSet.getString("accidentSize"));
				accident.setAccidentType(resultSet.getString("accidentType"));
				accident.setAccidentDate(resultSet.getString("accidentDate"));
				accident.setAccidentTime(resultSet.getString("accidentTime"));
				accident.setAccidentPlace(resultSet.getString("accidentPlace"));
				accident.setJudgementComplete(resultSet.getInt("judged"));
				accident.setDate(resultSet.getString("date"));
				accident.setCustomer(customer);

				accidentList.add(accident);
			}
			return accidentList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public AccidentList retrievecommpleted() {
		String query = "select * from accident left join accidentInfo on accidentInfo.accidentID = accident.accidentID where accidentInfo.completed = 0";
		AccidentList accidentList = new AccidentListImpl();
		try {
			ResultSet resultSet = this.retrieve(query);
			
			while ( resultSet.next()) {
				Customer customer = new Customer();
				customer.setCustomerID(resultSet.getInt("customerID"));
				
				Accident accident = new Accident();
				accident.setAccidentID(resultSet.getInt("accidentID"));
				accident.setAccidentSize(resultSet.getString("accidentSize"));
				accident.setAccidentType(resultSet.getString("accidentType"));
				accident.setAccidentDate(resultSet.getString("accidentDate"));
				accident.setAccidentTime(resultSet.getString("accidentTime"));
				accident.setAccidentPlace(resultSet.getString("accidentPlace"));
				accident.setJudgementComplete(resultSet.getInt("judged"));
				accident.setDate(resultSet.getString("date"));
				accident.setCustomer(customer);
				accidentList.add(accident);
			}
			return accidentList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int retrieveAccidentCnt(int customerID) {
		String query = "select COUNT(damageassess.accidentID) as rewardCnt from accident inner join damageassess using(accidentID) where customerID = " + customerID;
		
		int rewardCnt = 0;
		try {
			ResultSet resultSet = this.retrieve(query);
			
			while ( resultSet.next()) {
				rewardCnt = resultSet.getInt("rewardCnt");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rewardCnt;
	}
	

}
