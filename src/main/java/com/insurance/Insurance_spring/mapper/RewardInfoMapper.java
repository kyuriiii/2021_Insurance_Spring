package com.insurance.Insurance_spring.mapper;

import com.insurance.Insurance_spring.domain.reward.RewardInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RewardInfoMapper {
    void create(RewardInfo rewardInfo);
}
