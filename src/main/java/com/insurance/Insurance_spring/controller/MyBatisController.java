//package com.insurance.Insurance_spring.controller;
//
//import com.insurance.Insurance_spring.mybatis.dto.AccidentDTO;
//import com.insurance.Insurance_spring.mybatis.dto.CustomerDTO;
//import com.insurance.Insurance_spring.service.CustomerService;
//import com.insurance.Insurance_spring.service.RewardService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import java.util.List;
//
//@Controller
//public class MyBatisController {
//    private final CustomerService customerService;
//    private final RewardService rewardService;
//
//    @Autowired
//    public MyBatisController(CustomerService customerService, RewardService rewardService){
//        this.customerService = customerService;
//        this.rewardService = rewardService;
//    }
//
//    @GetMapping("mybatis/customer")
//    public String consultForm( Model model ){
//        List<CustomerDTO> customerDTOList = customerService.getCustomerList();
//        model.addAttribute( "customerList", customerDTOList );
//
//        return "mybatis/customer";
//    }
//
//    @GetMapping("reward/customerList")
//    public String rewardForm( Model model ){
//        List<AccidentDTO> accidentDTOList = rewardService.getAccidentList();
//        model.addAttribute("accidentList", accidentDTOList);
//        return "reward/customerList";
//    }
//}
