package com.insurance.Insurance_spring.service;

import com.insurance.Insurance_spring.domain.customer.Customer;
import com.insurance.Insurance_spring.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerMapper customerMapper;

    public List<Customer> getCustomerList(){
        return customerMapper.retrieve();
    }
}
