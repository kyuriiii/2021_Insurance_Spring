package com.insurance.Insurance_spring.mapper;

import com.insurance.Insurance_spring.domain.insurance.Coverage;
import com.insurance.Insurance_spring.domain.insurance.Insurance;
import com.insurance.Insurance_spring.domain.pCustomer.PCustomer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InsuranceMapper {
    List<Insurance> retrieve();
    int create( Insurance insurance );
    int createCoverage( Coverage coverage );
    Insurance retrieveByID( int insuranceID );
    int updateByID( Insurance insurance );
}