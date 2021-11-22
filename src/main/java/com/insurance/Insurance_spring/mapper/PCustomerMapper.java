package com.insurance.Insurance_spring.mapper;

import com.insurance.Insurance_spring.domain.pCustomer.PCustomer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PCustomerMapper {
    List<PCustomer> retrieve();
}