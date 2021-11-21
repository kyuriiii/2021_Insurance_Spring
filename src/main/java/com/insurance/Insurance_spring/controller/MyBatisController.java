package com.insurance.Insurance_spring.controller;

import com.insurance.Insurance_spring.mybatis.dto.CustomerDTO;
import com.insurance.Insurance_spring.mybatis.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MyBatisController {
    private final CustomerService customerService;

    @Autowired
    public MyBatisController( CustomerService customerService ){
        this.customerService = customerService;
    }

    @GetMapping("mybatis/customer")
    public String consultForm( Model model ){
        List<CustomerDTO> customerDTOList = customerService.getCustomerList();
        model.addAttribute( "customerList", customerDTOList );

        return "mybatis/customer";
    }
}
