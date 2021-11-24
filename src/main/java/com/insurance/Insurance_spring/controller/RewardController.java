package com.insurance.Insurance_spring.controller;

import com.insurance.Insurance_spring.domain.accident.Accident;
import com.insurance.Insurance_spring.domain.accident.AccidentList;
import com.insurance.Insurance_spring.domain.accident.AccidentListImpl;
import com.insurance.Insurance_spring.domain.contract.Contract;
import com.insurance.Insurance_spring.domain.contract.ContractList;
import com.insurance.Insurance_spring.domain.contract.ContractListImpl;
import com.insurance.Insurance_spring.domain.customer.Customer;
import com.insurance.Insurance_spring.domain.customer.CustomerList;
import com.insurance.Insurance_spring.domain.customer.CustomerListImpl;
import com.insurance.Insurance_spring.domain.exemption.Exemption;
import com.insurance.Insurance_spring.domain.exemption.ExemptionList;
import com.insurance.Insurance_spring.domain.exemption.ExemptionListImpl;
import com.insurance.Insurance_spring.domain.reward.RewardInfo;
import com.insurance.Insurance_spring.service.AccidentService;
import com.insurance.Insurance_spring.service.ContractService;
import com.insurance.Insurance_spring.service.CustomerService;
import com.insurance.Insurance_spring.service.RewardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RewardController {
    private Logger logger = LoggerFactory.getLogger(RewardController.class); // 로그 찍기

//    @Autowired
//    private RewardService rewardService; // 보상 관련 서비스 처리
//    @Autowired
//    private CustomerService customerService;
//    @Autowired
//    private ContractService contractService;
//    @Autowired
//    private AccidentService accidentService;
//
//    // list
//    private CustomerList customerList;
//    private ContractList contractList;
//    private AccidentList accidentList;
//    private ExemptionList exemptionList;
//
//    public RewardController(){
//        // list initialize
//        this.customerList = new CustomerListImpl();
//        this.contractList = new ContractListImpl();
//        this.accidentList = new AccidentListImpl();
//        this.exemptionList = new ExemptionListImpl();
//    }
//
//    @GetMapping("reward")
//        public String index() {
//            return "reward/index";
//        }
//
//    @GetMapping("/reward/consult")
//    public String consult(Model model){
//        // 계약을 맺은 고객 리스트
//        this.customerList.setCustomerList((ArrayList<Customer>) this.customerService.getCustomerList());
//        model.addAttribute( "customerList", this.customerList.getCustomerList() );
//        return "reward/consultForm";
//    }
//    @PostMapping("/reward/consult/customer")
//    public String consultCustomer(HttpServletRequest hsRequest, Model model){
//        // 사고 접수할 고객 선택 << use case 변경
//        model.addAttribute("customer", this.customerList.search(Integer.parseInt(hsRequest.getParameter("customerID"))));
//        // 선택한 고객ID로 DB에서 계약 리스트 불러서 저장
//        this.contractList.setContractList((ArrayList<Contract>) this.contractService.getContractListByID(Integer.parseInt(hsRequest.getParameter("customerID"))));
//        // 계약 리스트 web 뿌리기
//        model.addAttribute("contractList", this.contractList.getContractList()); // insurance name을 불러오지 못한다.
//        // 버튼 누르면 이동할 URL
//        model.addAttribute("moveUrl","reward/accept");
//        return "reward/accept";
//    }
//
//    @GetMapping("reward/accept")
//    public String accept(){
//        this.accidentList.setAccidentList((ArrayList<Accident>)this.accidentService.getAccidentList());
//        return "reward/acceptForm";
//    }
//    @PostMapping("reward/accept")
//    public String acceptAccident(HttpServletRequest hsRequest, Accident accident, Model model){
//        rewardService.createAccident(accident);
//        Accident a = rewardService.getAccident(accident.getCustomerID());
//        logger.info("accidentID: " + a.getAccidentID());
//        rewardService.createAccidentInfo(a);
//        model.addAttribute("accident", a);
//
//        return "redirect:/";
//    }
// ********************** 여기 아래는 수정 전이다 *****************
//    @GetMapping("reward/accident")
//    public String createAccidentForm(Model model){
//        // 접수된 사고 리스트
//        List<Accident> accidents = rewardService.getAccidentList();
//        model.addAttribute("accidentList", accidents);
//        return "reward/accidentForm";
//    }
//
//    @PostMapping("reward/accident")
//    public String accident(Accident accident, Model model){
//        // 현장 정보를 입력할 사고 선택
//        Accident a = rewardService.getAccident(accident.getAccidentID());
//        // 현장 정보 입력 완료 처리
//        rewardService.updateAccidentState(a);
//        // 현장 정보 저장
//        rewardService.createInvestigation(a.getM_siteInfo());
//        // Model에 값 저장
//        model.addAttribute("accidentInfo", a);
//        return "redirect:/";
//    }
//    @GetMapping("reward/exemption")
//    public String createExemptionForm(Model model){
//        // 면/부책 판단할 사고 리스트
//        List<Accident> accidents = rewardService.getAccidentList_Not();
//        model.addAttribute("accidentList", accidents);
//        return "reward/exemptionForm";
//    }
//    @PostMapping("reward/exemption")
//    public String exemption(Exemption exemption, Model model){
//        // 면/부책 판단할 사고 선택
//        Accident a = rewardService.getAccident(exemption.getExemptionID());
//        rewardService.updateJudged(a);
//        // 면/부책 인스턴스 저장
////        exemption.setAccidentID(a.getAccidentID()); // 사고 번호
////        exemption.setCustomerID(a.getCustomer().getCustomerID()); // 고객 번호
//        rewardService.createExemption(exemption);
//        // model에 저장
//        model.addAttribute("exemption", exemption);
//        return "redirect:/";
//    }
//    @GetMapping("reward/damage")
//    public String createDamageForm(Model model){
//        // 손해사정할 사고 리스트
//        List<Exemption> exemptions = rewardService.getExemptionList();
//        // 모델에 저장
//        model.addAttribute("exemptionList", exemptions);
//        return "reward/damageForm";
//    }
//    @PostMapping("reward/damage")
//    public String damage(RewardInfo rewardInfo, Model model){
//        // 손해사정할 사고 선택
//        Exemption e = rewardService.getExemption(rewardInfo.getAccident().getAccidentID());
//        rewardService.createRewardInfo(rewardInfo);
////        rewardService.deleteExemption(e.getAccidentID());
//        // 모델에 저장
//        model.addAttribute("reward", rewardInfo);
//        return "redirect:/";
//    }
}
