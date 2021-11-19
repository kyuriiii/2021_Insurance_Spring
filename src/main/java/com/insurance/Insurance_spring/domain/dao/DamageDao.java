package com.insurance.Insurance_spring.domain.dao;


import com.insurance.Insurance_spring.domain.reward.RewardInfo;

public interface DamageDao {
	public void create(RewardInfo rewardInfo);
	public RewardInfo retrieve();
	public void update (RewardInfo rewardInfo);
}
