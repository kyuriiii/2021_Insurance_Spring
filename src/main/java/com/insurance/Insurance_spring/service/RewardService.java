package com.insurance.Insurance_spring.service;

import com.insurance.Insurance_spring.domain.accident.Accident;
import com.insurance.Insurance_spring.domain.accident.SiteInfo;
import com.insurance.Insurance_spring.domain.contract.Contract;
import com.insurance.Insurance_spring.domain.customer.Customer;
import com.insurance.Insurance_spring.domain.exemption.Exemption;
import com.insurance.Insurance_spring.domain.reward.RewardInfo;
import com.insurance.Insurance_spring.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class RewardService {
    @Autowired
    private AccidentMapper accidentMapper;
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private  ContractMapper contractMapper;
    @Autowired
    private  ExemptionMapper exemptionMapper;
    @Autowired
    private  RewardInfoMapper rewardInfoMapper;
    private Customer customer;

    // accident
    public List<Accident> getAccidentList(){
        return accidentMapper.retrieveNotCompleted();
    }
    public Accident getAccident(int id){
        return accidentMapper.findById(id);
    }
    public void createAccident(Accident accidentDTO){
        accidentDTO.setCustomer(customer);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date now = new Date();
        String now_dt = format.format(now);
        accidentDTO.setDate(now_dt);
        accidentMapper.createAccident(accidentDTO);
    }
    public void updateAccidentState(Accident accidentDTO) {
        accidentMapper.updateState(accidentDTO);
    }
    public void createInvestigation(SiteInfo siteInfoDTO) {
        accidentMapper.createInvestigation(siteInfoDTO);
    }
    public List<Accident> getAccidentList_Not() {
        return accidentMapper.retrieveCompleted();
    }
    public void updateJudged(Accident a) {
        accidentMapper.updateJudged(a);
    }
    // customer
    public Customer getCustomer(String pcustomerName, String customerNumber) {
        return customerMapper.retrieveByInfo(pcustomerName, customerNumber);
    }
    // contract
    public List<Contract> getContractList(int customerID) {
        return contractMapper.findByID(customerID);
    }

    // exemption
    public void createExemption(Exemption exemption) {
        exemptionMapper.create(exemption);
    }
    public List<Exemption> getExemptionList() {
        return exemptionMapper.retrieveList();
    }
    public Exemption getExemption(int accidentID) {
        return exemptionMapper.findByID(accidentID);
    }
    public void deleteExemption(int accidentID) {
        exemptionMapper.deleteByID(accidentID);
    }
    // rewardInfo
    public void createRewardInfo(RewardInfo rewardInfo) {
        rewardInfoMapper.create(rewardInfo);
    }

    public void setCustomer(Customer m) {
        customer= m;
    }

    public void createAccidentInfo(Accident accident) {

        accidentMapper.createAccidentInfo(accident);
    }
}
