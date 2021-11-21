package com.insurance.Insurance_spring.mybatis.service;

import com.insurance.Insurance_spring.mybatis.dto.CustomerDTO;
import com.insurance.Insurance_spring.mybatis.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerMapper customerMapper;

    @Autowired
    public CustomerService(CustomerMapper customerMapper){
        this.customerMapper = customerMapper;
    }

    public List<CustomerDTO> getCustomerList(){
        return customerMapper.findAll();
    }
    public CustomerDTO getCustomer( int id ){
        return customerMapper.findById( id );
    }
    public String getAddressNum( String address ){
        return customerMapper.addressCheck( address );
    }
    public int createCustomer(CustomerDTO customerDTO){
        return customerMapper.createCustomer(customerDTO);
    }
}
