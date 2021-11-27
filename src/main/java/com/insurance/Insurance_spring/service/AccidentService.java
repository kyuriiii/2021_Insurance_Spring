package com.insurance.Insurance_spring.service;

import com.insurance.Insurance_spring.domain.accident.Accident;
import com.insurance.Insurance_spring.domain.accident.SiteInfo;
import com.insurance.Insurance_spring.domain.customer.Customer;
import com.insurance.Insurance_spring.mapper.AccidentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
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
        if(accidentDTO.getCustomer() != null) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date now = new Date();
            accidentDTO.setDate(format.format(now));
            accidentMapper.createAccident(accidentDTO);
        }
    }
    public void updateAccidentState(Accident accidentDTO) {
        accidentMapper.updateState(accidentDTO);
    }
    public void createInvestigation(SiteInfo siteInfoDTO) {
        accidentMapper.createInvestigation(siteInfoDTO);
    }
    public void updateJudged(Accident a) {
        accidentMapper.updateJudged(a);
    }
    public void createAccidentInfo(Accident accident) {
        accident.setCompleted(1);
        accident.setJudged(1);
        accidentMapper.createAccidentInfo(accident);
    }
}
