package com.insurance.Insurance_spring.controller;

public class ExemptionForm {
    private int exemptionID, subFile, judgementComplete;
    private String reason, legacy;

    public int getExemptionID() {
        return exemptionID;
    }

    public void setExemptionID(int exemptionID) {
        this.exemptionID = exemptionID;
    }

    public int getSubFile() {
        return subFile;
    }

    public void setSubFile(int subFile) {
        this.subFile = subFile;
    }

    public int getJudgementComplete() {
        return judgementComplete;
    }

    public void setJudgementComplete(int judgementComplete) {
        this.judgementComplete = judgementComplete;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getLegacy() {
        return legacy;
    }

    public void setLegacy(String legacy) {
        this.legacy = legacy;
    }
}
