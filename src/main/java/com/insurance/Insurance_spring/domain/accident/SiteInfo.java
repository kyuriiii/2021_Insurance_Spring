package com.insurance.Insurance_spring.domain.accident;

public class SiteInfo {
	private int photo, record, video;
	private String damageScale, scenario;
	
	public int getPhoto() {	return photo;	}
	public void setPhoto(int photo) {	this.photo = photo;	}
	public int getRecord() {	return record;	}
	public void setRecord(int record) {	this.record = record;	}
	public String getScenario() {	return scenario;	}
	public void setScenario(String scenario) {	this.scenario = scenario;	}
	public int getVideo() {	return video;	}
	public void setVideo(int video) {	this.video = video;	}
	public String getDamageScale() {	return damageScale;	}
	public void setDamageScale(String damageScale) {	this.damageScale = damageScale;	}
	public SiteInfo(){	}
	public void finalize() throws Throwable {	}
}