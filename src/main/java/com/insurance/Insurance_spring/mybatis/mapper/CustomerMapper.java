package com.insurance.Insurance_spring.mybatis.mapper;

import com.insurance.Insurance_spring.mybatis.dto.CustomerDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerMapper {

    List<CustomerDTO> findAll();
    CustomerDTO findById(int id);
    String addressCheck(String address);
    int createCustomer(CustomerDTO customerDTO);

    //void save(@Param("customerNumber") String customerNumber, @Param("email") String email);
}