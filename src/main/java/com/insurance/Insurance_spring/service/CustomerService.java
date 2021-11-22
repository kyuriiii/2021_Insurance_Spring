package com.insurance.Insurance_spring.service;

import com.insurance.Insurance_spring.domain.customer.Customer;
import com.insurance.Insurance_spring.mapper.CustomerMapper;
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

    public List<Customer> getCustomerList(){
        return customerMapper.findAll();
    }
    public Customer getCustomer( int id ){
        return customerMapper.findById( id );
    }
    public String getAddressNum( String address ){
        return customerMapper.addressCheck( address );
    }
    public int createCustomer(Customer customerDTO){
        return customerMapper.createCustomer(customerDTO);
    }
}
