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

    public List<Customer> getCustomerList(){ return customerMapper.retrieve(); }
    public Customer getCustomer( int customerID ){ return customerMapper.retrieveByID( customerID ); }
    public Customer getCustomerByInfo( String name, String customerNumber ){ return customerMapper.retrieveByInfo( name, customerNumber ); }
    public void create(Customer customer) { System.out.println( customer.getCustomerNumber() ); customerMapper.create( customer ); }
}
