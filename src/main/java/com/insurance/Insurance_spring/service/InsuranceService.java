package com.insurance.Insurance_spring.service;

import com.insurance.Insurance_spring.domain.insurance.Insurance;
import com.insurance.Insurance_spring.mapper.InsuranceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsuranceService {
    @Autowired
    private InsuranceMapper insuranceMapper;

    public List<Insurance> getInsuranceList(){ return insuranceMapper.retrieve(); }
    public Insurance getInsurance(int insuranceID ){ return insuranceMapper.retrieveByID( insuranceID ); }
}
