package com.insurance.Insurance_spring.service;

import com.insurance.Insurance_spring.domain.accident.Accident;
import com.insurance.Insurance_spring.domain.accident.SiteInfo;
import com.insurance.Insurance_spring.domain.customer.Customer;
import com.insurance.Insurance_spring.mapper.AccidentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class AccidentService {
    @Autowired
    private AccidentMapper accidentMapper;

    public List<Accident> getAccidentList(){
        return accidentMapper.retrieve();
    }
    public List<Accident> getCompletedAccidentList(){
        return accidentMapper.retrieveCompleted();
    }
    public List<Accident> getNotCompletedAccidentList(){
        return accidentMapper.retrieveNotCompleted();
    }
    public Accident getAccident(int id){
        return accidentMapper.findById(id);
    }
    public void createAccident(Accident accidentDTO){
        accidentMapper.createAccident(accidentDTO);
    }
    public void updateAccidentState(Accident accidentDTO) {
        accidentDTO.setCompleted(0);
        accidentMapper.updateState(accidentDTO);
    }
    public void createInvestigation(HashMap<String, Object> siteInfo) {
        accidentMapper.createInvestigation(siteInfo);
    }
    public void updateJudged(Accident a) {
        a.setJudged(0);
        accidentMapper.updateJudged(a);
    }
    public void createAccidentInfo(Accident accident) {
        accident.setCompleted(1);
        accident.setJudged(1);
        accidentMapper.createAccidentInfo(accident);
    }
}
