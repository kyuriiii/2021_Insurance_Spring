package com.insurance.Insurance_spring.service;

import com.insurance.Insurance_spring.domain.accident.Accident;
import com.insurance.Insurance_spring.domain.contract.Contract;
import com.insurance.Insurance_spring.domain.customer.Customer;
import com.insurance.Insurance_spring.mapper.ContractMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ContractService {
    @Autowired
    private ContractMapper contractMapper;

    public void create(HashMap<String,Object> infos){
        contractMapper.create(infos);
    }
    public List<Contract> getContractListByCustomerID(int customerID){
        return contractMapper.findByID(customerID);
    }
    public List<Contract> getContractList() { return contractMapper.findAll(); }
    public void update( Contract contract ){ contractMapper.update( contract ); }
}
