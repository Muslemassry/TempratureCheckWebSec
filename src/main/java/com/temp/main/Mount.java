package com.temp.main;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.temp.model.TempNote;
import com.temp.service.TempNoteService;

public class Mount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello");
		ApplicationContext context = new ClassPathXmlApplicationContext("resources/appContext.xml");
		TempNoteService tempNoteService = context.getBean("tempNoteService", TempNoteService.class);
		tempNoteService.getTempFromSrv();
		/*
		 * 
		 * TempNote tempNote = new TempNote();
		tempNote.setNoteDesc("this is the first test note");
		tempNote.setDegree(10);
		tempNote.setUserCreated("AMRGI");
		tempNote.setUserLastUpdate("AMRGI");
		tempNote.setDateCreated(new Date());
		tempNote.setDateLastUpdate(new Date());
		tempNoteService.setTodaysTempNote(tempNote);
		 */
		
		TempNote t = tempNoteService.getTodaysTempNote();
		System.out.println("finito");
	}

}
