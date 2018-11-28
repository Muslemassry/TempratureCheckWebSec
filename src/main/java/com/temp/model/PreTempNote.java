package com.temp.model;

public class PreTempNote extends BaseEntity {
	private Integer preTempNoteId;
	private Integer fromDegree;
	private Integer toDegree;
	private String perNoteDesc;
	
	public PreTempNote() {
		
	}

	public Integer getFromDegree() {
		return fromDegree;
	}

	public void setFromDegree(Integer fromDegree) {
		this.fromDegree = fromDegree;
	}

	public Integer getToDegree() {
		return toDegree;
	}

	public void setToDegree(Integer toDegree) {
		this.toDegree = toDegree;
	}

	public String getPerNoteDesc() {
		return perNoteDesc;
	}

	public void setPerNoteDesc(String perNoteDesc) {
		this.perNoteDesc = perNoteDesc;
	}

	public Integer getPreTempNoteId() {
		return preTempNoteId;
	}

	public void setPreTempNoteId(Integer preTempNoteId) {
		this.preTempNoteId = preTempNoteId;
	}
}
