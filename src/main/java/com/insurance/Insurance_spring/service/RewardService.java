package com.insurance.Insurance_spring.service;

import com.insurance.Insurance_spring.domain.accident.Accident;
import com.insurance.Insurance_spring.domain.accident.SiteInfo;
import com.insurance.Insurance_spring.domain.contract.Contract;
import com.insurance.Insurance_spring.domain.customer.Customer;
import com.insurance.Insurance_spring.domain.exemption.Exemption;
import com.insurance.Insurance_spring.domain.reward.RewardInfo;
import com.insurance.Insurance_spring.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class RewardService {
    @Autowired
    private  RewardInfoMapper rewardInfoMapper;


    // exemption
//    public void createExemption(Exemption exemption) {
//        exemptionMapper.create(exemption);
//    }
//    public List<Exemption> getExemptionList() {
//        return exemptionMapper.retrieveList();
//    }
//    public Exemption getExemption(int accidentID) {
//        return exemptionMapper.findByID(accidentID);
//    }
//    public void deleteExemption(int accidentID) {
//        exemptionMapper.deleteByID(accidentID);
//    }
    // rewardInfo
    public void createRewardInfo(RewardInfo rewardInfo) {
        rewardInfoMapper.create(rewardInfo);
    }
}
