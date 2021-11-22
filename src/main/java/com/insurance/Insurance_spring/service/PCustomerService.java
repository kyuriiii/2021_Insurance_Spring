package com.insurance.Insurance_spring.service;

import com.insurance.Insurance_spring.domain.pCustomer.PCustomer;
import com.insurance.Insurance_spring.mapper.PCustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PCustomerService {
    @Autowired
    private PCustomerMapper pCustomerMapper;

    public List<PCustomer> getPCustomerList(){
        return pCustomerMapper.retrieve();
    }
}
