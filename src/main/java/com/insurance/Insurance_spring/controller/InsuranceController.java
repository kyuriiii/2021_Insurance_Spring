package com.insurance.Insurance_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InsuranceController {
    @GetMapping("/")
    public String index( Model model ){
        return "index";
    }
    @GetMapping("insurance/")
    public String insurance( Model model ){
        return "insurance/index";
    }
    
    // 설계하기
    @GetMapping("insurance/design")
    public String insuranceDesign( Model model ){
        return "insurance/design";
    }


    // 상품 인가하기
    @GetMapping("insurance/approve")
    public String insuranceApprove( Model model ){
        return "insurance/approve";
    }
    
    
    // 사후 관리하기
    @GetMapping("insurance/manage")
    public String insuranceManage( Model model ){
        return "insurance/manage";
    }
}
