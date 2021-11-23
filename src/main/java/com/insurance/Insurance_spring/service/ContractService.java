package com.insurance.Insurance_spring.service;

import com.insurance.Insurance_spring.mapper.ContractMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractService {
    @Autowired
    private ContractMapper contractMapper;
}
