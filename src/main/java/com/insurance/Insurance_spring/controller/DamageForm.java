package com.insurance.Insurance_spring.controller;

public class DamageForm {
    private String payment, assessReason;
    private int accidentID;

    public int getAccidentID() {
        return accidentID;
    }

    public void setAccidentID(int accidentID) {
        this.accidentID = accidentID;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getAssessReason() {
        return assessReason;
    }

    public void setAssessReason(String assessReason) {
        this.assessReason = assessReason;
    }
}
