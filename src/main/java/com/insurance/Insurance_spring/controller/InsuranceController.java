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
    @GetMapping("insurance/design")
    public String insuranceDesign( Model model ){
        return "insurance/design";
    }
    @GetMapping("insurance/approve")
    public String insuranceApprove( Model model ){
        return "insurance/approve";
    }
    @GetMapping("insurance/manage")
    public String insuranceManage( Model model ){
        return "insurance/manage";
    }
}
