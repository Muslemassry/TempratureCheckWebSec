package com.temp.model;

import java.util.Date;

public class TempNote extends BaseEntity {
	private Integer tempNoteId;
	private Date day;
	private String noteDesc;
	private Integer degree;
	
	public TempNote() {
		
	}

	public Date getDay() {
		return day;
	}

	public void setDay(Date day) {
		this.day = day;
	}

	public String getNoteDesc() {
		return noteDesc;
	}

	public void setNoteDesc(String noteDesc) {
		this.noteDesc = noteDesc;
	}

	public Integer getDegree() {
		return degree;
	}

	public void setDegree(Integer degree) {
		this.degree = degree;
	}

	public Integer getTempNoteId() {
		return tempNoteId;
	}

	public void setTempNoteId(Integer tempNoteId) {
		this.tempNoteId = tempNoteId;
	}
}
