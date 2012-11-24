package com.pinkdroid.dealshunter.network;

import java.util.List;

public interface NetworkManager {
	
	public void loadDealItem();
	
	
	////////////////////
	public void submitReactorData(List<Integer> dataList, boolean isReactorCompleted);
	public void downloadAverage();
	public void downloadProgramList();
}
