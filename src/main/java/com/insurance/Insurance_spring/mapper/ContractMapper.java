package com.insurance.Insurance_spring.mapper;

import com.insurance.Insurance_spring.domain.contract.Contract;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface ContractMapper {
    void create(HashMap<String,Object> infos);
    List<Contract> findAll();
    List<Contract> findByID(int customerID);

}
