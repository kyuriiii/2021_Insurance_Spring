package com.insurance.Insurance_spring.mapper;

import com.insurance.Insurance_spring.domain.accident.Accident;
import com.insurance.Insurance_spring.domain.accident.SiteInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface AccidentMapper {

    List<HashMap<String, Object>> findAll();
    Accident findById(int accidentID);
    void createAccident(Accident accidentDTO);
    void updateState(Accident accidentDTO);
    void updateJudged(Accident accidentDTO);
    void createInvestigation(HashMap<String, Object> siteInfos);
    void createAccidentInfo(Accident accidentDTO);
    List<Accident> retrieveNotCompleted();
    int accidentCnt(int customerID);
    List<Accident> retrieve();
    void delete( int accidentID);
}
