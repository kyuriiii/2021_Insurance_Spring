package com.insurance.Insurance_spring.controller;

import com.insurance.Insurance_spring.domain.accident.Accident;
import com.insurance.Insurance_spring.domain.accident.AccidentList;
import com.insurance.Insurance_spring.domain.accident.AccidentListImpl;
import com.insurance.Insurance_spring.domain.contract.Contract;
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
import com.insurance.Insurance_spring.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

@Controller
public class SalesController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private PCustomerService pCustomerService;
    @Autowired
    private InsuranceService insuranceService;
    @Autowired
    private AccidentService accidentService;
    @Autowired
    private ContractService contractService;

    private CustomerList customerList;
    private PCustomerList pCustomerList;
    private ContractList contractList;
    private InsuranceList insuranceList;
    private AccidentList accidentList;

    private Library_UW libraryUW;

    public SalesController(){
        this.customerList = new CustomerListImpl();
        this.pCustomerList = new PCustomerListImpl();
        this.contractList = new ContractListImpl();
        this.insuranceList = new InsuranceListImpl();
        this.accidentList = new AccidentListImpl();

        this.libraryUW = new Library_UW();
    }

    @GetMapping("sales")
    public String index( Model model ){
        return "sales/index";
    }

    // 예비 고객 관리하기
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

    
    // 계약하기
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
        model.addAttribute( "insurance", this.insuranceList.search( Integer.parseInt( hsRequest.getParameter( "insuranceID" ) ) ) );
        model.addAttribute( "customer", this.customerList.search( Integer.parseInt( hsRequest.getParameter( "customerID" ) ) ) );

        return "sales/contract/accident";
    }
    @PostMapping("sales/contract_building")
    public String contract_building( HttpServletRequest hsRequest, Accident accident, Building building, Model model ){
        accidentService.createAccident( accident );
        HashMap<String, Object> buildingInfos = new HashMap<String, Object>();
        buildingInfos.put("customerID", Integer.parseInt(hsRequest.getParameter( "customerID" )));
        buildingInfos.put("building", building);
        customerService.createBuildingInfo( buildingInfos );

        Insurance insurance = this.insuranceList.search( Integer.parseInt( hsRequest.getParameter( "insuranceID" ) ) );
        Customer customer = this.customerList.search( Integer.parseInt( hsRequest.getParameter( "customerID" ) ) );

        customer.setAccident( accident );
        customer.setM_building( building );

        return contractAfterInfo( insurance, customer, model );
    }
    @PostMapping("sales/contract_car")
    public String contract_car(Accident accident, Car car, HttpServletRequest hsRequest, Model model ){
        accidentService.createAccident( accident );
        HashMap<String, Object> carInfos = new HashMap<String, Object>();
        carInfos.put("customerID", Integer.parseInt(hsRequest.getParameter( "customerID" )));
        carInfos.put("car", car);
        customerService.createCarInfo( carInfos );

        Insurance insurance = this.insuranceList.search( Integer.parseInt( hsRequest.getParameter( "insuranceID" ) ) );
        Customer customer = this.customerList.search( Integer.parseInt( hsRequest.getParameter( "customerID" ) ) );

        customer.setAccident( accident );
        customer.setM_car( car );

        return contractAfterInfo( insurance, customer, model );
    }
    @PostMapping("sales/contract_driver")
    public String contract_driver(Accident accident, Driver driver, Car car, HttpServletRequest hsRequest, Model model ){
        accidentService.createAccident( accident );
        HashMap<String, Object> carInfos = new HashMap<String, Object>();
        carInfos.put("customerID", Integer.parseInt(hsRequest.getParameter( "customerID" )));
        carInfos.put("car", car);
        customerService.createCarInfo( carInfos );
        HashMap<String, Object> driverInfos = new HashMap<String, Object>();
        driverInfos.put("customerID", Integer.parseInt(hsRequest.getParameter( "customerID" )));
        driverInfos.put("driver", driver);
        customerService.createDriverInfo( driverInfos );

        Insurance insurance = this.insuranceList.search( Integer.parseInt( hsRequest.getParameter( "insuranceID" ) ) );
        Customer customer = this.customerList.search( Integer.parseInt( hsRequest.getParameter( "customerID" ) ) );

        customer.setAccident( accident );
        customer.setM_car( car );
        customer.setM_driver( driver );

        return contractAfterInfo( insurance, customer, model );
    }
    private String contractAfterInfo( Insurance insurance, Customer customer, Model model){
        int uwRate = this.libraryUW.calcualteFactors( insurance, customer );
        if ( uwRate == 1 ){
            model.addAttribute( "msg", "인수심사 결과 계약을 체결할 수 없습니다." );
            return contract( model );
        }

        Contract contract = new Contract();
        contract.setInsurance( insurance );
        contract.setCustomer( customer );
        float insuranceRatio = contract.calculateRatio();

        model.addAttribute( "customer", customer );
        model.addAttribute( "insurance", insurance );

        int finalPrice = 0;
        if ( insuranceRatio != 0 ) finalPrice = (int) ( Integer.parseInt(insurance.getInsuranceCost()) * insuranceRatio );
        else finalPrice = Integer.parseInt(insurance.getInsuranceCost());

        model.addAttribute( "finalPrice", finalPrice );
        model.addAttribute( "insuranceRatio", insuranceRatio );

        return "sales/contract/contractRatio";
    }
    @PostMapping("sales/contractContinue")
    public String contractContinue(HttpServletRequest hsRequest, Contract contract, Model model ){
        HashMap<String,Object> infos = new HashMap<String, Object>();
        infos.put("customerID", Integer.parseInt(hsRequest.getParameter( "customerID" )));
        infos.put("insuranceID", Integer.parseInt(hsRequest.getParameter( "insuranceID" )));
        infos.put("contract", contract);
        contractService.create( infos );
        model.addAttribute( "msg", "계약에 성공했습니다." );
        return "redirect:/sales/contract";
    }
    @PostMapping("sales/contractCancel")
    public String contractCancel(HttpServletRequest hsRequest, Model model ){
        Customer customer = this.customerList.search( Integer.parseInt( hsRequest.getParameter( "customerID" ) ) );
        for ( Accident accident : customer.getAccident() ){
            accidentService.delete( accident.getAccidentID() );
        }
        switch ( hsRequest.getParameter( "type" ) ){
            case "building": customerService.deleteBuildingInfo( customer.getM_building().getBuildingID() ); break;
            case "car": customerService.deleteCarInfo( customer.getM_car().getCarID() ); break;
            case "driver":
                customerService.deleteCarInfo( customer.getM_car().getCarID() );
                customerService.deleteDriverInfo( customer.getM_driver().getDriverID() );
            break;
        }

        model.addAttribute( "msg", customer.getPcustomerName() + " 님과의 계약이 취소되었습니다." );
        return contract( model );
    }

    
    // 계약 관리하기
    @GetMapping( "sales/ctManage" )
    public String ctManage( Model model ){
        this.contractList.setContractList((ArrayList<Contract>) contractService.getContractList() );

        for ( Contract contract : this.contractList.getContractList() ){
            contract.setCustomer( customerService.getCustomer( contract.getCustomerID() ) );
            contract.setInsurance( insuranceService.getInsurance( contract.getInsuranceID() ) );
        }

        model.addAttribute( "contractList", this.contractList.getContractList() );
        return "sales/ctManage/index";
    }
    @PostMapping( "sales/ctManage" )
    public String ctManagePost( HttpServletRequest hsRequest, Model model ){
        model.addAttribute( "contract", this.contractList.search( Integer.parseInt( hsRequest.getParameter( "contractID" ) ) ) );
        return "sales/ctManage/manage";
    }
    @PostMapping( "sales/ctManage/extend" )
    public String ctManageExtend( Contract contract, Model model ){
        contractService.update( contract );
        return "redirect:/sales";
    }
}
