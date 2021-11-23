package com.insurance.Insurance_spring.service;

import com.insurance.Insurance_spring.domain.insurance.Insurance;
import com.insurance.Insurance_spring.domain.pCustomer.PCustomer;
import com.insurance.Insurance_spring.mapper.InsuranceMapper;
import com.insurance.Insurance_spring.mapper.PCustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsuranceService {
    @Autowired
    private InsuranceMapper insuranceMapper;

    public List<Insurance> getInsuranceList(){
        return insuranceMapper.retrieve();
    }
}
