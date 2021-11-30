package com.insurance.Insurance_spring.service;

import com.insurance.Insurance_spring.domain.insurance.Approve;
import com.insurance.Insurance_spring.domain.insurance.Coverage;
import com.insurance.Insurance_spring.domain.insurance.Insurance;
import com.insurance.Insurance_spring.mapper.InsuranceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class InsuranceService {
    @Autowired
    private InsuranceMapper insuranceMapper;

    public int create(Insurance insurance) { return insuranceMapper.create( insurance ); }
    public int createCoverage(Coverage coverage) { return insuranceMapper.createCoverage( coverage ); }
    public int createApprove(Approve approve) { return insuranceMapper.createApprove( approve ); }
    public List<Insurance> getInsuranceList(){ return insuranceMapper.retrieve(); }
    public List<Insurance> getInsuranceListNoApprove(){ return insuranceMapper.retrieveNoApprove(); }
    public Insurance getInsurance(int insuranceID ){ return insuranceMapper.retrieveByID( insuranceID ); }
    public Coverage getCoverage( HashMap<String, Object> coverageInfo ){ return insuranceMapper.retrieveCoverage( coverageInfo ); }
}
