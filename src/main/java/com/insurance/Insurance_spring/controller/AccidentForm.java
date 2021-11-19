package com.insurance.Insurance_spring.controller;

public class AccidentForm {
    private int id, photo, record, video;
    private String damageScale, scenario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public int getRecord() {
        return record;
    }

    public void setRecord(int record) {
        this.record = record;
    }

    public int getVideo() {
        return video;
    }

    public void setVideo(int video) {
        this.video = video;
    }

    public String getDamageScale() {
        return damageScale;
    }

    public void setDamageScale(String damageScale) {
        this.damageScale = damageScale;
    }

    public String getScenario() {
        return scenario;
    }

    public void setScenario(String scenario) {
        this.scenario = scenario;
    }
}
