package com.insurance.Insurance_spring.domain.accident;

public class SiteInfo {
	private int photo, record, video;
	private String scale, scenario;
	
	public int getPhoto() {	return photo;	}
	public void setPhoto(int photo) {	this.photo = photo;	}
	public int getRecord() {	return record;	}
	public void setRecord(int record) {	this.record = record;	}
	public String getScenario() {	return scenario;	}
	public void setScenario(String scenario) {	this.scenario = scenario;	}
	public int getVideo() {	return video;	}
	public void setVideo(int video) {	this.video = video;	}
	public String getScale() {	return scale;	}
	public void setScale(String scale) {	this.scale = scale;	}
	public SiteInfo(){	}
	public void finalize() throws Throwable {	}
}