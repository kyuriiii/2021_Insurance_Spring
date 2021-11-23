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
}
