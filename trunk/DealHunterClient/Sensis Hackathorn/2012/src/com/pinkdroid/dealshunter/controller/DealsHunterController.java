package com.pinkdroid.dealshunter.controller;

import java.util.ArrayList;

import com.pinkdroid.dealshunter.model.Deal;

import android.app.Application;

public class DealsHunterController extends Application{
	private static DealsHunterController _instance;
	
	@Override
	public void onCreate(){
		_instance = this;
	}
	
	public static DealsHunterController getInstance(){
		if(_instance==null)
			_instance = new DealsHunterController();
		return _instance;
	}
	ArrayList<Deal> dealList = new ArrayList<Deal>();

	public ArrayList<Deal> getDealList() {
		return dealList;
	}

	public void setDealList(ArrayList<Deal> dealList) {
		this.dealList = dealList;
	}
	
	
}
