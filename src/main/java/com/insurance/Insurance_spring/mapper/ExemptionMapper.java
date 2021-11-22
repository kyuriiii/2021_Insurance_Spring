package com.insurance.Insurance_spring.mapper;

import com.insurance.Insurance_spring.domain.exemption.Exemption;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExemptionMapper {
    void create(Exemption exemption);
    List<Exemption> retrieveList();

    Exemption findByID(int accidentID);

    void deleteByID(int accidentID);
}
