package com.temp.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.temp.model.PreTempNote;
import com.temp.model.TempNote;

@Repository
public class TempNoteDAO {
	private SessionFactory sessionFactory;
	
	public TempNote getTempNote(Date date) {
		Query query = sessionFactory.getCurrentSession().createQuery("from TempNote where day = :day");
		query.setParameter("day", date);
		List<TempNote> empList = query.getResultList();
		if (empList != null && !empList.isEmpty())
			return empList.get(0);
		else
			return null;
	}
	
	public Integer saveTempNote(TempNote tempNote) {
		return (Integer) sessionFactory.getCurrentSession().save(tempNote);
	}
	
	public void saveOrUpdatePreTempNote(PreTempNote preTempNote) {
		sessionFactory.getCurrentSession().update(preTempNote);
	}
	
	public void saveOrUpdateTempNote(TempNote tempNote) {
		sessionFactory.getCurrentSession().update(tempNote);
	}
	
	public List<PreTempNote> getPreTempNotes() {
		Query query = sessionFactory.getCurrentSession().createQuery("from PreTempNote");
		return query.getResultList();
	}
	
	public PreTempNote getPreTempNote(Integer preTempNoteId) {
		Query query = sessionFactory.getCurrentSession().createQuery("from PreTempNote where preTempNoteId = :preTempNoteId");
		query.setParameter("preTempNoteId", preTempNoteId);
		List<PreTempNote> tempList = query.getResultList();
		if (tempList  != null && !tempList.isEmpty())
			return tempList.get(0);
		else
			return null;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
