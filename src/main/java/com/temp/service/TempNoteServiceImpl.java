package com.temp.service;

import java.util.Date;
import java.util.List;

import com.temp.dao.TempNoteDAO;
import com.temp.exception.BusinessException;
import com.temp.model.PreTempNote;
import com.temp.model.TempNote;
import com.temp.utils.DateUtils;

public class TempNoteServiceImpl implements TempNoteService {

	private TempNoteDAO tempNoteDao;

	public int getTempFromSrv() {
		System.out.println("here we are in the test ya deesha");
		return 0;
	}

	public boolean setTodaysTempNote(TempNote tempNote) throws BusinessException {
		if(getTodaysTempNote() != null) {
			throw new BusinessException("today_note_already_saved");
		}
		
		tempNote.setDay(DateUtils.getDateWithoutTime(new Date()));
		Integer added = tempNoteDao.saveTempNote(tempNote);
		return (added == null) ? false : true;
	}

	public TempNote getTodaysTempNote() {
		return tempNoteDao.getTempNote(DateUtils.getDateWithoutTime(new Date()));
	}
	
	public List<PreTempNote> getPreTempNotes() {
		return tempNoteDao.getPreTempNotes();
	}

	public void saveOrUpdatePreTempNote(PreTempNote preTempNote) {
		tempNoteDao.saveOrUpdatePreTempNote(preTempNote);
	}
	
	public void saveOrUpdateTempNote(TempNote tempNote) {
		tempNoteDao.saveOrUpdateTempNote(tempNote);
	}

	public TempNoteDAO getTempNoteDao() {
		return tempNoteDao;
	}

	public void setTempNoteDao(TempNoteDAO tempNoteDao) {
		this.tempNoteDao = tempNoteDao;
	}

	@Override
	public PreTempNote getPreTempNote(Integer preTempNoteId) {
		return tempNoteDao.getPreTempNote(preTempNoteId);
	}
}
