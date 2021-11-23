package com.insurance.Insurance_spring.service;

import com.insurance.Insurance_spring.domain.customer.Customer;
import com.insurance.Insurance_spring.domain.pCustomer.PCustomer;
import com.insurance.Insurance_spring.mapper.PCustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PCustomerService {
    @Autowired
    private PCustomerMapper pCustomerMapper;

    public List<PCustomer> getPCustomerList(){
        return pCustomerMapper.retrieve();
    }
    public void updateByID( PCustomer pcustomer ) {  System.out.println( pcustomer.getPCustomerID() + " " + pcustomer.getPcustomerName() + " " + pcustomer.getConsultContext() ); pCustomerMapper.updateByID( pcustomer );}
}
