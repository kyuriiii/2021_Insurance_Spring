package com.insurance.Insurance_spring.controller;

import com.insurance.Insurance_spring.domain.insurance.*;
import com.insurance.Insurance_spring.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;

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
        this.insuranceList.setInsuranceList( (ArrayList<Insurance>) insuranceService.getInsuranceListNoApprove() );
        model.addAttribute( "insuranceNoApprove", this.insuranceList.getInsuranceList() );
        return "insurance/approve";
    }
    @PostMapping("insurance/approve")
    public String insuranceApproveDo( HttpServletRequest hsRequest, Model model ){
        Insurance insurance = this.insuranceList.search( Integer.parseInt( hsRequest.getParameter( "insuranceID" ) ) );
        HashMap<String, Object> coverage = new HashMap<String, Object>();
        coverage.put("insuranceID", Integer.parseInt( hsRequest.getParameter( "insuranceID" ) ));
        coverage.put("coverageCondition", "high");

        insurance.setM_hcoverage( insuranceService.getCoverage( coverage ) );
        coverage.put("coverageCondition", "middle" );
        insurance.setM_mcoverage( insuranceService.getCoverage( coverage ) );
        coverage.put("coverageCondition", "low" );
        insurance.setM_lcoverage( insuranceService.getCoverage( coverage ) );

        model.addAttribute( "insurance", insurance );
        return "insurance/approveDo";
    }
    @PostMapping("insurance/approveDone")
    public String insuranceApproveDone(Approve approve, Model model ){
        insuranceService.createApprove( approve );

        this.insuranceList.search( approve.getInsuranceID() ).setM_approve( approve );

        model.addAttribute( "msg", "상품 인가가 완료되었습니다." );
        return index( model );
    }

    
    
    // 사후 관리하기
    @GetMapping("insurance/manage")
    public String insuranceManage( Model model ){
        insuranceList.setInsuranceList((ArrayList<Insurance>) insuranceService.getInsuranceList());
        model.addAttribute("insuranceList", this.insuranceList.getInsuranceList());
        return "insurance/manage";
    }
    @PostMapping("/insurance/manage/info")
    public String insuranceInfo(HttpServletRequest hsRequest, Model model){
        Insurance insurance = this.insuranceList.search( Integer.parseInt( hsRequest.getParameter( "insuranceID" ) ) );
        HashMap<String, Object> coverage = new HashMap<String, Object>();
        coverage.put("insuranceID", Integer.parseInt( hsRequest.getParameter( "insuranceID" ) ));
        coverage.put("coverageCondition", "high");

        insurance.setM_hcoverage( insuranceService.getCoverage( coverage ) );
        coverage.put("coverageCondition", "middle" );
        insurance.setM_mcoverage( insuranceService.getCoverage( coverage ) );
        coverage.put("coverageCondition", "low" );
        insurance.setM_lcoverage( insuranceService.getCoverage( coverage ) );

        model.addAttribute( "insurance", insurance );

        SaleRecord saleRecord = insuranceService.getSaleRecord( Integer.parseInt( hsRequest.getParameter( "insuranceID" ) ) );
        if ( saleRecord != null ) model.addAttribute( "saleRecord", saleRecord );
        else model.addAttribute( "saleRecord", null );

        return "insurance/manageDo";
    }
    @PostMapping("/insurance/manageDone")
    public String insuranceManageDone( SaleRecord saleRecord , Model model){
        insuranceService.createSaleRecord(saleRecord);
        this.insuranceList.search(saleRecord.getInsuranceID()).setM_SaleRecord(saleRecord);
        model.addAttribute("msg", "판매실적표 작성이 완료되었습니다.");
        return index(model);
    }
}
