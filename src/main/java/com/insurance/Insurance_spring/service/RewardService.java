package com.insurance.Insurance_spring.service;

import com.insurance.Insurance_spring.controller.RewardController;
import com.insurance.Insurance_spring.domain.reward.RewardInfo;
import com.insurance.Insurance_spring.mapper.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

@Service
public class RewardService {
    private Logger logger = LoggerFactory.getLogger(RewardController.class); // 로그 찍기
    // 비동기로 쓰레드 처리
//    @Autowired
//    @Qualifier("executor")
//    private ThreadPoolTaskExecutor executor;

    @Autowired
    private  RewardInfoMapper rewardInfoMapper;

    // rewardInfo
    public void createRewardInfo(RewardInfo rewardInfo) {
        rewardInfoMapper.create(rewardInfo);
    }

//    @Async("executor")
//    public void executeThreads(){
//        logger.info("executing threads ........");
//        Runnable r = () ->{
//            try{
//                logger.info(Thread.currentThread().getName() + ", Now sleeping 10 seconds ...");
//                Thread.sleep(10000);
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//        };
//        for(int i = 0; i<10; i++){
//            executor.execute(r);
//        }
//    }

}
