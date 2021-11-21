package com.insurance.Insurance_spring.mybatis.dto;

import lombok.Data;

@Data
public class CustomerDTO {
    private int customerID, pcustomerID;
    private String address, customerNumber, email;

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getPcustomerID() {
        return pcustomerID;
    }

    public void setPcustomerID(int pcustomerID) {
        this.pcustomerID = pcustomerID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
