package com.insurance.Insurance_spring.controller;

import com.insurance.Insurance_spring.domain.customer.Customer;
import com.insurance.Insurance_spring.domain.customer.CustomerList;
import com.insurance.Insurance_spring.domain.customer.CustomerListImpl;
import com.insurance.Insurance_spring.domain.pCustomer.PCustomer;
import com.insurance.Insurance_spring.domain.pCustomer.PCustomerList;
import com.insurance.Insurance_spring.domain.pCustomer.PCustomerListImpl;
import com.insurance.Insurance_spring.service.CustomerService;
import com.insurance.Insurance_spring.service.MyBatisCustomerService;
import com.insurance.Insurance_spring.service.PCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class SalesController {
    @Autowired
    private MyBatisCustomerService myBatisCustomerService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private PCustomerService pCustomerService;

    private CustomerList customerList;
    private PCustomerList pCustomerList;

    public SalesController(){
        this.customerList = new CustomerListImpl();
        this.pCustomerList = new PCustomerListImpl();
    }

    @GetMapping("sales/consult")
    public String consult( Model model ){
        this.pCustomerList.setCustomerList((ArrayList<PCustomer>) pCustomerService.getPCustomerList());
        model.addAttribute( "pCustomerList", this.pCustomerList.getCustomerList() );

        return "sales/consult";
    }
    @PostMapping("sales/consult")
    public String consult( Customer customer, Model model ){
        return "hi";
    }
}
