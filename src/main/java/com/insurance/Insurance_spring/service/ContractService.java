package com.insurance.Insurance_spring.service;

import com.insurance.Insurance_spring.domain.contract.Contract;
import com.insurance.Insurance_spring.mapper.ContractMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService {
    @Autowired
    private ContractMapper contractMapper;

    public List<Contract> getContractListByID(int customerID){
        return contractMapper.findByID(customerID);
    }

    public List<Contract> getContractList() {
        return contractMapper.findAll();
    }
}
