package com.insurance.Insurance_spring.mapper;

import com.insurance.Insurance_spring.domain.customer.Customer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerMapper {

    List<Customer> findAll();
    Customer findById(int id);
    String addressCheck(String address);
    int createCustomer(Customer customerDTO);

    Customer findByName();

    //void save(@Param("customerNumber") String customerNumber, @Param("email") String email);
}