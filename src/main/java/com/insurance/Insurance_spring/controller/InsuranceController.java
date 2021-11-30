package com.insurance.Insurance_spring.controller;

import com.insurance.Insurance_spring.domain.insurance.Coverage;
import com.insurance.Insurance_spring.domain.insurance.Insurance;
import com.insurance.Insurance_spring.domain.insurance.InsuranceList;
import com.insurance.Insurance_spring.domain.insurance.InsuranceListImpl;
import com.insurance.Insurance_spring.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class InsuranceController {
    @Autowired
    private InsuranceService insuranceService;

    private InsuranceList insuranceList;

    public InsuranceController(){
        this.insuranceList = new InsuranceListImpl();
    }

    @GetMapping("/")
    public String index( Model model ){
        return "index";
    }
    @GetMapping("insurance")
    public String insurance( Model model ){
        return "insurance/index";
    }
    
    // 설계하기
    @GetMapping("insurance/design")
    public String insuranceDesign( Model model ){ return "insurance/design"; }
    @PostMapping("insurance/design")
    public String insuranceDesignDo(Insurance insurance, HttpServletRequest hsRequest, Model model ){
        insuranceService.create( insurance );
        Coverage hCoverage = new Coverage();
        hCoverage.setInsuranceID(insurance.getInsuranceID());
        hCoverage.setCoverageCondition("high");
        hCoverage.setCoverageContent( hsRequest.getParameter( "hContent" ));
        hCoverage.setCoverageCost( Integer.parseInt( hsRequest.getParameter( "hCost" ) ));
        insuranceService.createCoverage( hCoverage );

        Coverage mCoverage = new Coverage();
        mCoverage.setInsuranceID(insurance.getInsuranceID());
        mCoverage.setCoverageCondition("middle");
        mCoverage.setCoverageContent( hsRequest.getParameter( "mContent" ));
        mCoverage.setCoverageCost( Integer.parseInt( hsRequest.getParameter( "mCost" ) ));
        insuranceService.createCoverage( mCoverage );

        Coverage lCoverage = new Coverage();
        lCoverage.setInsuranceID(insurance.getInsuranceID());
        lCoverage.setCoverageCondition("low");
        lCoverage.setCoverageContent( hsRequest.getParameter( "lContent" ));
        lCoverage.setCoverageCost( Integer.parseInt( hsRequest.getParameter( "lCost" ) ));
        insuranceService.createCoverage( lCoverage );

        model.addAttribute( "msg", insurance.getInsuranceName() + " 상품 설계가 완료되었습니다." );
        return index( model );
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
