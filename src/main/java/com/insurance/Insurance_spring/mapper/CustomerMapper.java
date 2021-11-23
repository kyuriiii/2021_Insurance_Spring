package com.insurance.Insurance_spring.mapper;

import com.insurance.Insurance_spring.domain.customer.Customer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerMapper {
    List<Customer> retrieve();
    Customer retrieveByID( int customerID );
    Customer retrieveByInfo( String name, String customerNumber );
    int create( Customer customer );
}