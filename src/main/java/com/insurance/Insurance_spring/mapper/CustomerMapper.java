package com.insurance.Insurance_spring.mapper;

import com.insurance.Insurance_spring.domain.customer.Customer;
import com.insurance.Insurance_spring.dto.CustomerDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerMapper {
    List<Customer> retrieve();
}