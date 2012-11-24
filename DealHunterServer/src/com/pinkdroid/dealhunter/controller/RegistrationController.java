package com.pinkdroid.dealhunter.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.pinkdroid.dealhunter.db.DatabaseHelper;

public class RegistrationController extends AbstractController{
	
	DatabaseHelper dbHelper;
	
	public RegistrationController() {
		dbHelper = new DatabaseHelper();
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	

}
