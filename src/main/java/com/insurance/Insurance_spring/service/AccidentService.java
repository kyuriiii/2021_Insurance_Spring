package com.insurance.Insurance_spring.service;

import com.insurance.Insurance_spring.domain.accident.Accident;
import com.insurance.Insurance_spring.mapper.AccidentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccidentService {
    @Autowired
    private AccidentMapper accidentMapper;

    public List<Accident> getAccidentList(){
        return accidentMapper.retrieveNotCompleted();
    }
    public List<Accident> getCompletedAccidentList(){
        return accidentMapper.retrieveCompleted();
    }
}
