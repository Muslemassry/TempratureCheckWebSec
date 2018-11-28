package com.temp.service;

import java.util.List;

import com.temp.exception.BusinessException;
import com.temp.model.PreTempNote;
import com.temp.model.TempNote;

public interface TempNoteService {
	public int getTempFromSrv();
	public boolean setTodaysTempNote(TempNote tempNote) throws BusinessException;
	public TempNote getTodaysTempNote();
	public void saveOrUpdatePreTempNote(PreTempNote preTempNote);
	public List<PreTempNote> getPreTempNotes();
	public PreTempNote getPreTempNote(Integer preTempNoteId);
}
