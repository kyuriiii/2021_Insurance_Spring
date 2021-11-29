package com.insurance.Insurance_spring.service;

import com.insurance.Insurance_spring.domain.reward.RewardInfo;
import com.insurance.Insurance_spring.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RewardService {
    @Autowired
    private  RewardInfoMapper rewardInfoMapper;

    // rewardInfo
    public void createRewardInfo(RewardInfo rewardInfo) {
        rewardInfoMapper.create(rewardInfo);
    }
}
