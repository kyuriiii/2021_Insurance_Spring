package com.insurance.Insurance_spring.mapper;

import com.insurance.Insurance_spring.domain.contract.Contract;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ContractMapper {
    List<Contract> findAll();
    List<Contract> findByID();

}
