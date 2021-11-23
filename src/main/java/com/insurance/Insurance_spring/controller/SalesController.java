package com.insurance.Insurance_spring.controller;

import com.insurance.Insurance_spring.domain.accident.Accident;
import com.insurance.Insurance_spring.domain.contract.ContractList;
import com.insurance.Insurance_spring.domain.contract.ContractListImpl;
import com.insurance.Insurance_spring.domain.customer.*;
import com.insurance.Insurance_spring.domain.insurance.Insurance;
import com.insurance.Insurance_spring.domain.insurance.InsuranceList;
import com.insurance.Insurance_spring.domain.insurance.InsuranceListImpl;
import com.insurance.Insurance_spring.domain.pCustomer.PCustomer;
import com.insurance.Insurance_spring.domain.pCustomer.PCustomerList;
import com.insurance.Insurance_spring.domain.pCustomer.PCustomerListImpl;
import com.insurance.Insurance_spring.library.Library_UW;
import com.insurance.Insurance_spring.service.CustomerService;
import com.insurance.Insurance_spring.service.InsuranceService;
import com.insurance.Insurance_spring.service.PCustomerService;
import org.apache.tomcat.jni.Library;
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
    @Autowired
    private InsuranceService insuranceService;

    private CustomerList customerList;
    private PCustomerList pCustomerList;
    private ContractList contractList;
    private InsuranceList insuranceList;

    private Library_UW libraryUW;

    public SalesController(){
        this.customerList = new CustomerListImpl();
        this.pCustomerList = new PCustomerListImpl();
        this.contractList = new ContractListImpl();
        this.insuranceList = new InsuranceListImpl();

        this.libraryUW = new Library_UW();
    }

    @GetMapping("sales")
    public String index( Model model ){
        return "sales/index";
    }

    @GetMapping("sales/consult")
    public String consult( Model model ){
        this.pCustomerList.setCustomerList((ArrayList<PCustomer>) pCustomerService.getPCustomerList());
        model.addAttribute( "pCustomerList", this.pCustomerList.getCustomerList() );

        return "sales/consult/consultList";
    }
    @PostMapping("sales/consult")
    public String consult( HttpServletRequest hsRequest, Model model ){
        model.addAttribute( "pCustomer", this.pCustomerList.search( Integer.parseInt( hsRequest.getParameter( "pcustomerID" ) ) ) );

        return "sales/consult/consult";
    }
    @PostMapping("sales/consultDo")
    public String consultDo( HttpServletRequest hsRequest, Customer customer, Model model ){
        PCustomer pcustomer = this.pCustomerList.search( Integer.parseInt( hsRequest.getParameter( "pcustomerID" ) ) );
        pcustomer.setConsultContext( hsRequest.getParameter( "consultContext" ) );

        customer.setPCustomerID( Integer.parseInt( hsRequest.getParameter( "pcustomerID" ) ) );

        this.pCustomerService.updateByID( pcustomer );
        this.customerService.create( customer );

        return "redirect:/sales/consult";
    }
    @GetMapping("sales/contract")
    public String contract( Model model ){
        this.customerList.setCustomerList((ArrayList<Customer>) this.customerService.getCustomerList());
        model.addAttribute( "customerList", this.customerList.getCustomerList() );

        return "sales/contract/customer";
    }
    @PostMapping("sales/contract/insurance")
    public String contractInsurance( HttpServletRequest hsRequest, Model model ){
        model.addAttribute( "customer", this.customerList.search( Integer.parseInt( hsRequest.getParameter( "customerID" ) ) ) );
        this.insuranceList.setInsuranceList((ArrayList<Insurance>) this.insuranceService.getInsuranceList());
        model.addAttribute( "insuranceList", this.insuranceList.getInsuranceList() );

        return "sales/contract/insurance";
    }
    @PostMapping("sales/contract/contractCustomer")
    public String contractCustomer( HttpServletRequest hsRequest, Model model ){
        Insurance insurance = this.insuranceList.search( Integer.parseInt( hsRequest.getParameter( "insuranceID" ) ) );

        model.addAttribute( "insurance", insurance );
        model.addAttribute( "customer", this.customerList.search( Integer.parseInt( hsRequest.getParameter( "customerID" ) ) ) );

        return "sales/contract/accident";
    }
    @PostMapping("sales/contract_building")
    public String contractBuilding( HttpServletRequest hsRequest, Model model ){
//        logger.info( "accidentSize : ", accident.getAccidentSize() );
//        logger.info( "buildingSize : ", building.getBuildingSize() );
        logger.info( "customerID : ", hsRequest.getParameter( "customerID" ) );
        logger.info( "insuranceID : ", hsRequest.getParameter( "insuranceID" ) );

        return "redirect:/sales/contract";
    }
    @PostMapping("sales/contract_car")
    public String contractBuilding(Accident accident, Car car, HttpServletRequest hsRequest, Model model ){
        return "";
    }
    @PostMapping("sales/contract_driver")
    public String contractBuilding(Accident accident, Driver driver, HttpServletRequest hsRequest, Model model ){
        return "";
    }
}
