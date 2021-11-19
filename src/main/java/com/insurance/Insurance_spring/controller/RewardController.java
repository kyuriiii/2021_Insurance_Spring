package com.insurance.Insurance_spring.controller;

import com.insurance.Insurance_spring.domain.accident.Accident;
import com.insurance.Insurance_spring.domain.contract.Contract;
import com.insurance.Insurance_spring.domain.customer.Customer;
import com.insurance.Insurance_spring.domain.employee.Employee;
import com.insurance.Insurance_spring.domain.exemption.Exemption;
import com.insurance.Insurance_spring.domain.reward.RewardInfo;
import com.insurance.Insurance_spring.service.RewardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class RewardController {
    private Logger logger = LoggerFactory.getLogger(RewardController.class); // 로그 찍기

    private final RewardService rewardService; // 보상 관련 서비스 처리
 
    @Autowired
    public RewardController(RewardService rewardService) {
        this.rewardService = rewardService;
    } // 스프링 시작 시, 초기화

    @GetMapping("/reward/consult")
    public String consultForm(){ // 고객 이름, 주민번호를 입력받을 페이지로 이동
        return "reward/consultForm";
    }
    @PostMapping("/reward/consult")
    public String consult(ConsultForm consultForm, Model model){ // 고객 이름, 주민번호로 DB에 있는지 확인하기
        // customer 객체 생성
        Customer customer = new Customer();
        // web에서 입력한 이름, 주민번호 저장
        customer.setCustomerName(consultForm.getName());
        customer.setCustomerNumber(consultForm.getNumber());
        // DB에 존재하는 고객인지 확인 후, 고객 데이터 전부를 담고 있는 customer 리턴
        Customer m = rewardService.check_customer(customer);
        // customer 객체에 리턴 받은 m에서 데이터 추출해서 set
        customer.seteMail(m.geteMail());
        customer.setJob(m.getJob());
        customer.setSex(m.getSex());
        customer.setAddress(m.getAddress());
        customer.setCustomerID(m.getCustomerID());

        Contract contract = rewardService.check_contract(customer.getCustomerID());
        rewardService.storeCustomer(customer); // 고객을 따로 저장장
        // web(reward/customerInfo)에 보여줄 데이터를 model 객체에 담기. ("html파일의 each랑 이름이 같아야 한다.", 객체)
        model.addAttribute("customer", customer);
        model.addAttribute("contract", contract);

        // move url
        String moveUrl = "accept";
        model.addAttribute("moveUrl", moveUrl);

        return "reward/customerInfo"; // 위에서 처리한 로직을 보여줄 결과 페이지로 이동
    }

    @GetMapping("reward/accept")
    public String createAcceptForm(){
        return "reward/acceptForm";
    }

    @PostMapping("reward/accept")
    public String acceptForm(AcceptForm acceptForm, Model model){
        Accident accident = new Accident();
        accident.setAccidentDate(acceptForm.getAccidentDate());
        accident.setAccidentPlace(acceptForm.getAccidentPlace());
        accident.setAccidentTime(acceptForm.getAccidentTime());
        accident.setAccidentType(acceptForm.getAccidentType());
        accident.setAccidentSize(acceptForm.getAccidentSize());

        Accident m = rewardService.store(accident);
        accident.setAccidentID(m.getAccidentID());

        model.addAttribute("accident", accident);

        return "redirect:/";
    }

    @GetMapping("/")
    public String list(Model model){ // DB에 저장된 고객 리스트 (아이디, 이름), 계약 리스트
        ArrayList<Customer> customerDTOList = rewardService.check_customer();
        ArrayList<Contract> contractDTOList = rewardService.check_contract();
        ArrayList<Accident> accidentDTOList = rewardService.check_accident();

        model.addAttribute("customerList", customerDTOList);
        model.addAttribute("contractList", contractDTOList);
        model.addAttribute("accidentList", accidentDTOList);
        return "reward/customerList";
    }

    @GetMapping("reward/accident")
    public String createAccidentForm(Model model){
        // 접수된 사고 리스트
        ArrayList<Accident> accidents = rewardService.check_accident_NotCompleted();
        model.addAttribute("accidentList", accidents);
        return "reward/accidentForm";
    }

    @PostMapping("reward/accident")
    public String accident(AccidentForm accidentForm, Model model){

        // 현장 정보를 입력할 사고 선택
        Accident a = rewardService.check_accident(accidentForm.getId());
        // Web에서 받은 사고 현장 정보
        a.setAccidentComplete(0); // 현장 정보 입력 완료 처리
        // 현장 정보 저장
        a.getM_siteInfo().setScenario(accidentForm.getScenario());
        a.getM_siteInfo().setDamageScale(accidentForm.getDamageScale());
        a.getM_siteInfo().setRecord(accidentForm.getRecord());
        a.getM_siteInfo().setPhoto(accidentForm.getPhoto());
        a.getM_siteInfo().setVideo(accidentForm.getVideo());
        // DB 데이터 업데이트
        rewardService.update(a);
        // Model에 값 저장

        model.addAttribute("accidentInfo", a);
        return "redirect:/";
    }
    @GetMapping("reward/exemption")
    public String createExemptionForm(Model model){
        // 면/부책 판단할 사고 리스트
        ArrayList<Accident> accidents = rewardService.check_accident_Completed();
        model.addAttribute("accidentList", accidents);
        return "reward/exemptionForm";
    }
    @PostMapping("reward/exemption")
    public String exemption(ExemptionForm exemptionForm, Model model){
        // 면/부책 판단할 사고 선택
        Accident a = rewardService.check_exemption(exemptionForm.getExemptionID());
        a.setJudgementComplete(exemptionForm.getJudgementComplete());
        // DB 데이터 업데이트 for accident judged
        rewardService.update(a);
        // 면/부책 인스턴스 생성 및 데이터 저장
        Exemption e = new Exemption();
        e.setAccidentID(a.getAccidentID()); // 사고 번호
        e.setCustomerID(a.getCustomer().getCustomerID()); // 고객 번호
        e.setLegacy(exemptionForm.getLegacy()); // 법률
        e.setReason(exemptionForm.getReason()); // 근거
        e.setSubFile(exemptionForm.getSubFile()); // 참고자료
        // DB에 저장
        rewardService.storeExemption(e);
        // model에 저장
        model.addAttribute("exemption", e);
        return "redirect:/";
    }
    @GetMapping("reward/damage")
    public String createDamageForm(Model model){
        // 손해사정할 사고 리스트
        ArrayList<Exemption> exemptions = rewardService.check_damage();
        // 모델에 저장
        model.addAttribute("exemptionList", exemptions);
        return "reward/damageForm";
    }
    @PostMapping("reward/damage")
    public String damage(DamageForm damageForm, Model model){
        // 손해사정할 사고 선택
        Exemption e = rewardService.check_damage(damageForm.getAccidentID());
        // 보상 인스턴스 생성 및 데이터 저장
        RewardInfo r = new RewardInfo();
        r.setAccident(e);
        r.setAssessReason(damageForm.getAssessReason());
        r.setPayment(damageForm.getPayment());
        r.setEmployee(new Employee(1234)); // employee 어떡하지

        rewardService.storeReward(r); // DB에 저장
        rewardService.deleteExemption(e.getAccidentID()); // accidentlist에서 제거
        // 모델에 저장
        model.addAttribute("reward", r);
        return "redirect:/";
    }
}
