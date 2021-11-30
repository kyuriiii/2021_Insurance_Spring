package com.insurance.Insurance_spring.service;

import com.insurance.Insurance_spring.domain.exemption.Exemption;
import com.insurance.Insurance_spring.mapper.ExemptionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExemptionService {

    @Autowired
    private ExemptionMapper exemptionMapper;

    public List<Exemption> getExemptionList(){
        return this.exemptionMapper.retrieveList();
    }

    public void create(Exemption exemption) {
        this.exemptionMapper.create(exemption);
    }

    public void delete(int accidentID) {
        this.exemptionMapper.deleteByID(accidentID);
    }
}
