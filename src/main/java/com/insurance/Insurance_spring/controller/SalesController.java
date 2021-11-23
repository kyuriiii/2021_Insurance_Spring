package com.insurance.Insurance_spring.controller;

import com.insurance.Insurance_spring.domain.customer.Customer;
import com.insurance.Insurance_spring.domain.customer.CustomerList;
import com.insurance.Insurance_spring.domain.customer.CustomerListImpl;
import com.insurance.Insurance_spring.domain.pCustomer.PCustomer;
import com.insurance.Insurance_spring.domain.pCustomer.PCustomerList;
import com.insurance.Insurance_spring.domain.pCustomer.PCustomerListImpl;
import com.insurance.Insurance_spring.service.CustomerService;
import com.insurance.Insurance_spring.service.PCustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
public class SalesController {
    private Logger logger = LoggerFactory.getLogger(RewardController.class); // 로그 찍기

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

        return "sales/consultList";
    }
    @PostMapping("sales/consult")
    public String consult( HttpServletRequest httpServletRequest, Model model ){
        model.addAttribute( "pCustomer", this.pCustomerList.search( Integer.parseInt( httpServletRequest.getParameter( "pcustomerID" ) ) ) );

        return "sales/consult";
    }
    @PostMapping("sales/consultDo")
    public String consultDo( HttpServletRequest httpServletRequest, Customer customer, Model model ){
        PCustomer pcustomer = this.pCustomerList.search( Integer.parseInt( httpServletRequest.getParameter( "pcustomerID" ) ) );
        pcustomer.setConsultContext( httpServletRequest.getParameter( "consultContext" ) );

        customer.setPCustomerID( Integer.parseInt( httpServletRequest.getParameter( "pcustomerID" ) ) );

        this.pCustomerService.updateByID( pcustomer );
        this.customerService.create( customer );

        return "redirect:/sales/consult";
    }
}
