package com.insurance.Insurance_spring.controller;

import com.insurance.Insurance_spring.domain.accident.Accident;
import com.insurance.Insurance_spring.domain.contract.Contract;
import com.insurance.Insurance_spring.domain.customer.Customer;
import com.insurance.Insurance_spring.domain.exemption.Exemption;
import com.insurance.Insurance_spring.domain.reward.RewardInfo;
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

import java.util.List;

@Controller
public class RewardController {
    private Logger logger = LoggerFactory.getLogger(RewardController.class); // 로그 찍기

//    private final RewardService rewardService; // 보상 관련 서비스 처리
//
//    @Autowired
//    public RewardController(RewardService rewardService) {
//        this.rewardService = rewardService;
//    } // 스프링 시작 시, 초기화
//
//    @GetMapping("/reward/consult")
//    public String consultForm(Model model){ // 고객 이름, 주민번호를 입력받을 페이지로 이동
//        model.addAttribute("customer", new Customer());
//        model.addAttribute("contract", new Contract());
//        return "reward/consultForm";
//    }
//    @PostMapping("/reward/consult")
//    public String consult(@Validated Customer customer, BindingResult result, Model model){ // 고객 이름, 주민번호로 DB에 있는지 확인하기
//        if(result.hasErrors()){return "reward/consultForm";}
//        // DB에 존재하는 고객인지 확인 후, 고객 데이터 전부를 담고 있는 customer 리턴
//        Customer m = rewardService.getCustomer(customer.getPcustomerName(), customer.getCustomerNumber());
//        rewardService.setCustomer(m);
//        // DB에서 고객이 자사와 계약한 계약들 리턴
////        List<Contract> contracts = rewardService.getContractList(m.getCustomerID());
//
//        // web(reward/customerInfo)에 보여줄 데이터를 model 객체에 담기. ("html파일의 each랑 이름이 같아야 한다.", 객체)
//        model.addAttribute("customer", m);
////        model.addAttribute("contract", contracts);
//
//        // move url
//        String moveUrl = "accept";
//        model.addAttribute("moveUrl", moveUrl);
//
//        return "reward/customerInfo"; // 위에서 처리한 로직을 보여줄 결과 페이지로 이동
//    }
//
//    @GetMapping("reward/accept")
//    public String createAcceptForm(){
//        return "reward/acceptForm";
//    }
//
//    @PostMapping("reward/accept")
//    public String acceptForm(Accident accident, Model model){
//        rewardService.createAccident(accident);
//        Accident a = rewardService.getAccident(accident.getCustomerID());
//        logger.info("accidentID: " + a.getAccidentID());
//        rewardService.createAccidentInfo(a);
//        model.addAttribute("accident", a);
//
//        return "redirect:/";
//    }
//
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
