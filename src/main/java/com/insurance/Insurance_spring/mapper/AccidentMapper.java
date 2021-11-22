package com.insurance.Insurance_spring.mapper;

import com.insurance.Insurance_spring.domain.accident.Accident;
import com.insurance.Insurance_spring.domain.accident.SiteInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AccidentMapper {

    List<Accident> findAll();
    Accident findById(int id);
    void createAccident(Accident accidentDTO);
    void updateState(Accident accidentDTO);
    void updateJudged(Accident accidentDTO);
    void createInvestigation(SiteInfo siteInfoDTO);
    void createAccidentInfo(Accident accidentDTO);
    List<Accident> retrieveNotCompleted();
    List<Accident> retrieveCompleted();
    int accidentCnt(int customerID);
}
