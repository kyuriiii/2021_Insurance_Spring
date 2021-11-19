package com.insurance.Insurance_spring.service;

import com.insurance.Insurance_spring.domain.accident.Accident;
import com.insurance.Insurance_spring.domain.accident.AccidentList;
import com.insurance.Insurance_spring.domain.contract.Contract;
import com.insurance.Insurance_spring.domain.contract.ContractList;
import com.insurance.Insurance_spring.domain.customer.Customer;
import com.insurance.Insurance_spring.domain.customer.CustomerList;
import com.insurance.Insurance_spring.domain.dao.*;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;

@Service
public class RewardService {

    private final CustomerDao customerDao;
    private final CustomerList customerList;
    private final ContractDao contractDao;
    private final ContractList contractList;
    private final AccidentDao accidentDao;
    private final AccidentList accidentList;

    private Customer customer;

    private Logger logger;

    @Autowired
    public RewardService() {
        customerDao = new CustomerDaoImpl();
        contractDao = new ContractDaoImpl();
        accidentDao = new AccidentDaoImpl();

        this.customerList = customerDao.retrieve();
        this.contractList = contractDao.retrieve();
        this.accidentList = accidentDao.retrieve();
    }

    public ArrayList<Customer> check() {
       return this.customerList.getCustomerList();
    }
    public Customer check(Customer customer) {
        return this.customerList.search(customer);
    }
    public ArrayList<Contract> check_contract() {
        return this.contractList.getContractList();
    }
    public Contract check_contract(int customerID) {
        return this.contractList.searchByCustomer(customerID);
    }

    public Accident store(Accident accident) {
        // 고객 저장
        accident.setCustomer(this.customer);
        // 사고 ID 생성 및 저장
        int id = this.accidentDao.create(accident);
        accident.setAccidentID(id);
        // 사고 default 설정
        accident.setAccidentComplete(1);
        accident.setJudgementComplete(1);
        accident.setDate(LocalDate.now(ZoneId.of("Asia/Seoul")).toString());
        this.accidentDao.createInfo(accident);
        this.accidentList.add(accident);
        return accident;
    }

    public ArrayList<Accident> check_accident() {
        return this.accidentList.getAccidentList();
    }
    public Accident check_accident(int id) {
        return this.accidentList.search(id);
    }

    public void storeCustomer(Customer customer) { // 얘를 여기서 처리하는 게 맞는 걸까?
        this.customer = customer;
    }

    public ArrayList<Accident> check_accident_NotCompleted() { // 현장 조사가 되지 않은 사고만 불러오기
        logger.info("??" + accidentDao.retrieveNotcompleted().getAccidentList().size()); // null 이래..
        return this.accidentDao.retrieveNotcompleted().getAccidentList();
    }

    public void update(Accident a) {
        // DB 현장정보 테이블에 사고 인스턴스 저장
        this.accidentDao.createInvestigation(a);
        // DB accident 테이블에 현장 조사 '미처리>처리'로 변경
        this.accidentDao.update(a);
    }
}
