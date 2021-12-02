package com.insurance.Insurance_spring.controller;

import com.insurance.Insurance_spring.domain.accident.Accident;
import com.insurance.Insurance_spring.domain.accident.AccidentList;
import com.insurance.Insurance_spring.domain.accident.AccidentListImpl;
import com.insurance.Insurance_spring.domain.accident.SiteInfo;
import com.insurance.Insurance_spring.domain.contract.Contract;
import com.insurance.Insurance_spring.domain.contract.ContractList;
import com.insurance.Insurance_spring.domain.contract.ContractListImpl;
import com.insurance.Insurance_spring.domain.customer.Customer;
import com.insurance.Insurance_spring.domain.customer.CustomerList;
import com.insurance.Insurance_spring.domain.customer.CustomerListImpl;
import com.insurance.Insurance_spring.domain.exemption.Exemption;
import com.insurance.Insurance_spring.domain.exemption.ExemptionList;
import com.insurance.Insurance_spring.domain.exemption.ExemptionListImpl;
import com.insurance.Insurance_spring.domain.insurance.InsuranceList;
import com.insurance.Insurance_spring.domain.insurance.InsuranceListImpl;
import com.insurance.Insurance_spring.domain.reward.RewardInfo;
import com.insurance.Insurance_spring.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class RewardController {
    private Logger logger = LoggerFactory.getLogger(RewardController.class); // 로그 찍기

    @Autowired
    private RewardService rewardService; // 보상 관련 서비스 처리
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ContractService contractService;
    @Autowired
    private AccidentService accidentService;
    @Autowired
    private ExemptionService exemptionService;

    // list
    private CustomerList customerList;
    private ContractList contractList;
    private AccidentList accidentList;
    private ExemptionList exemptionList;

    public RewardController(){
        // list initialize
        this.customerList = new CustomerListImpl();
        this.contractList = new ContractListImpl();
        this.accidentList = new AccidentListImpl();
        this.exemptionList = new ExemptionListImpl();
    }

    @GetMapping("reward")
        public String index() {
        // 계약을 맺은 고객 리스트
        this.customerList.setCustomerList((ArrayList<Customer>) this.customerService.getCustomerList());
        // DB에 있는 모든 사고 리스트 ( Accident만 가져 옴 )
        this.accidentList.setAccidentList((ArrayList<Accident>) this.accidentService.getAccidentList());

        return "reward/index";
        }

    @GetMapping("/reward/consult")
    public String consult(Model model){
        if(this.customerList.getCustomerList().size() == 0){ // index를 거치지 않고 올 경우
            this.customerList.setCustomerList((ArrayList<Customer>) this.customerService.getCustomerList());
        }
        model.addAttribute( "customerList", this.customerList.getCustomerList() );
        return "reward/consultForm";
    }
    @PostMapping("/reward/consult/customer")
    public String consultCustomer(HttpServletRequest hsRequest, Model model){
        // consultForm에서 받은 customerID로 customer 찾기
        model.addAttribute("customer", this.customerList.search(Integer.parseInt(hsRequest.getParameter("customerID"))));
        // contractList = customerID가 갖는 Contract만 가짐
        this.contractList.setContractList(((ArrayList<Contract>) this.contractService.getContractListByCustomerID(Integer.parseInt(hsRequest.getParameter("customerID")))));
        model.addAttribute("contractList",this.contractList.getContractList() );
        return "reward/customerInfo";
    }
    @PostMapping("/reward/accept/customer")
    public String showAccept( HttpServletRequest hsRequest, Model model ){

        model.addAttribute("customer", this.customerList.search(Integer.parseInt(hsRequest.getParameter("customerID"))));

        return "reward/acceptForm";
    }
    @PostMapping("/reward/accept")
    public String accept( HttpServletRequest hsRequest, Model model, Accident accident ){
        if(this.accidentList.getAccidentList().size() == 0 ){
            this.accidentList.setAccidentList((ArrayList<Accident>) this.accidentService.getAccidentList());
        }
        Customer customer = this.customerList.search(Integer.parseInt(hsRequest.getParameter("customerID")));
        accident.setCustomerID(customer.getCustomerID());

        accidentService.createAccident(accident);
        this.accidentList.add(accident);

        Accident a = this.accidentList.search(this.accidentList.getAccidentList().get(this.accidentList.getAccidentList().size()-1).getAccidentID());

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date now = new Date();
        a.setDate(format.format(now));
        accidentService.createAccidentInfo(a);
        model.addAttribute("accidentList", this.accidentService.getCompletedAccidentList());
        return "redirect:/reward/consult";
    }
    @GetMapping("/reward/accept/accidentInfo")
    public String acceptInfo(Model model){
        model.addAttribute("accidentList", this.accidentService.getNotCompletedAccidentList());
        return "reward/accidentForm";
    }
    @PostMapping("/reward/accident")
    public String accident( HttpServletRequest hsRequest, SiteInfo siteInfo, Model model){
        if(this.accidentList.getAccidentList().size() == 0) this.accidentList.setAccidentList((ArrayList<Accident>) this.accidentService.getAccidentList());
        Accident accident = this.accidentList.search(Integer.parseInt(hsRequest.getParameter("accidentID"))); // index.html에서 시작하지 않으면 초기화되지 않아서 null이다.
        accident.setM_siteInfo(siteInfo);
        this.accidentService.updateAccidentState(accident);

        // HashMap으로 sql 접근
        HashMap<String, Object> siteinfos = new HashMap<String, Object>();
        siteinfos.put("accidentID", accident.getAccidentID());
        siteinfos.put("siteInfo", siteInfo);

        this.accidentService.createInvestigation(siteinfos);
        return "reward/index";
    }
    @GetMapping("/reward/exemption")
    public String showExemption( Model model ){
        if(this.accidentList.getAccidentList().size() == 0) this.accidentList.setAccidentList((ArrayList<Accident>) this.accidentService.getAccidentList());

        List<HashMap<String, Object>> map = this.accidentService.getCompletedAccidentList(); // accidentID, siteInfo
        ArrayList<Accident> beforeExemption = new ArrayList<Accident>();
        for(int i = 0; i< map.size(); i++){
            Accident accident = this.accidentList.search((int) map.get(i).get("accidentID"));
            SiteInfo s = new SiteInfo();
            s.setScenario((String) map.get(i).get("scenario"));
            s.setRecord((Integer) map.get(i).get("record"));
            s.setVideo((Integer) map.get(i).get("video"));
            s.setPhoto((Integer) map.get(i).get("photo"));
            s.setScale((String) map.get(i).get("scale"));
            accident.setM_siteInfo(s);
            beforeExemption.add(accident);
        }

        model.addAttribute("accidentList", beforeExemption);
        return "reward/exemptionForm";
    }
    @PostMapping("/reward/exemption")
    public String exemption ( HttpServletRequest hsRequest, Exemption exemption ){
        if(this.accidentList.getAccidentList().size() == 0) this.accidentList.setAccidentList((ArrayList<Accident>) this.accidentService.getAccidentList());
        Accident accident = this.accidentList.search(exemption.getAccidentID());
        accident.setJudged(Integer.parseInt(hsRequest.getParameter("judged")));

        this.exemptionList.setExemptionList((ArrayList<Exemption>) this.exemptionService.getExemptionList());

        this.exemptionService.create(exemption);
        this.accidentService.updateJudged(accident);
        this.exemptionList.add(exemption);

        return "reward/index";
    }
    @GetMapping("/reward/damage")
    public String damage( Model model ){
        if(this.exemptionList.getExemptionList().size() > 0) this.exemptionList.getExemptionList().clear();
        this.exemptionList.setExemptionList((ArrayList<Exemption>) this.exemptionService.getExemptionList());
        model.addAttribute("exemptionList", this.exemptionList.getExemptionList());
        return "reward/damageForm";
    }
    @PostMapping("/reward/damage")
    public String damage( HttpServletRequest hsRequest, Model model ){
        Exemption exemption = this.exemptionList.search(Integer.parseInt(hsRequest.getParameter("accidentID")));

        model.addAttribute("accidentID", exemption.getAccidentID());
        model.addAttribute("exemption", exemption);
        return "reward/damageForm_Do";
    }
    @PostMapping("/reward/damageDo")
    public String damageDo (RewardInfo rewardInfo ) {
        this.rewardService.createRewardInfo(rewardInfo);
        this.exemptionService.delete(rewardInfo.getAccidentID());
        return "reward/index";
    }
}
