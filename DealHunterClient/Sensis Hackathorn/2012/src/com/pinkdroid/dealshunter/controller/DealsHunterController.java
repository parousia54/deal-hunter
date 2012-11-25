package com.pinkdroid.dealshunter.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import com.google.android.maps.GeoPoint;
import com.pinkdroid.dealshunter.model.Business;
import com.pinkdroid.dealshunter.model.Deal;
import com.pinkdroid.dealshunter.model.Deal.UserFeedback;
import com.pinkdroid.dealshunter.screen.view.DealViewerPageFragment;

import android.app.Application;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

public class DealsHunterController extends Application {
	private static DealsHunterController _instance;
	private static LocationManager locationManager;
	public static GeoPoint userCurrGeoPoint;
	public ArrayList<Deal> fakedeals = new ArrayList<Deal>();
	private Deal selectedDeal = null;
	//Parlour Hairdressing, MYERS, DENDY Cinema, Hoyts Cinema, Mai Thai Vietnamese Restaurant
	
	
	ArrayList<Deal> dealList = new ArrayList<Deal>();

	private LocationListener locationListener = new LocationListener() {
		public void onLocationChanged(Location location) {
			if (location != null) {
				userCurrGeoPoint = new GeoPoint((int) (1E6 * location.getLatitude()), (int) (1E6 * location.getLongitude()));
			}
		}

		public void onStatusChanged(String provider, int status, Bundle b) {
		}

		public void onProviderEnabled(String provider) {
		}

		public void onProviderDisabled(String provider) {
		}
	};

	@Override
	public void onCreate() {
		_instance = this;
		if (locationManager == null) {
			locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
		}
		if (locationManager != null) {
			locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
		}
		
		fakedeals.add(new Deal(0, Business.businesses.get(0), new Date(2012, 11, 25, 9, 0), new Date(112, 12, 25, 17, 0), 2, 1, new UserFeedback(454, 12), 0, null,
				"50% discount on hair extension. Two year wrranty!"));
		fakedeals.add(new Deal(1, Business.businesses.get(1), new Date(2012, 11, 6, 9, 0), new Date(112, 11, 21, 17, 0), 20, 1, new UserFeedback(232, 23), 0, null, "$20 Off on all eletrical appliances"));
		fakedeals.add(new Deal(2, Business.businesses.get(3), new Date(2012, 11, 2, 9, 0), new Date(112, 11, 25, 17, 0), 10, 1, new UserFeedback(3224, 543), 0, null, "$11 Ticket for SkyFall every monday"));
		fakedeals.add(new Deal(3, Business.businesses.get(1), new Date(2012, 11, 6, 9, 0), new Date(112, 12, 21, 17, 0), 120, 1, new UserFeedback(3343, 232), 0, null,
				"Buy any two shirts to get the third one FREE*, Hurry up while stocks last"));
		fakedeals.add(new Deal(4, Business.businesses.get(3), new Date(2012, 11, 6, 9, 0), new Date(112, 12, 21, 17, 0), 5, 1, new UserFeedback(234, 1222), 0, null, "$8 Movie ticket for all movies*"));
		fakedeals.add(new Deal(5, Business.businesses.get(3), new Date(2012, 11, 6, 9, 0), new Date(112, 11, 21, 17, 0), 8, 1, new UserFeedback(23, 12), 0, null, "$8 Gold Class Movie Ticket on Wednesday"));
		fakedeals.add(new Deal(6, Business.businesses.get(4), new Date(2012, 11, 6, 9, 0), new Date(112, 11, 27, 17, 0), 2, 1, new UserFeedback(3434, 656), 0, null,
				"Spend more than $20 on dinner to get 30% discount"));
		fakedeals.add(new Deal(7, Business.businesses.get(1), new Date(2012, 11, 6, 9, 0), new Date(112, 12, 29, 17, 0), 11, 1, new UserFeedback(1, 12), 0, null,
				"$40 for Hola games"));
	}

	@Override
	public void onTerminate() {
		if (locationManager != null) {
			locationManager.removeUpdates(locationListener);
		}
		super.onTerminate();
	}

	public static DealsHunterController getInstance() {
		if (_instance == null)
			_instance = new DealsHunterController();
		return _instance;
	}

	public ArrayList<Deal> getDealList(int pageType) {
		ArrayList<Deal> returnList = (ArrayList<Deal>)fakedeals.clone();
		switch(pageType){
			case DealViewerPageFragment.POPULAR_PAGE_ID:{
				Collections.sort(returnList,popularListComparator);
				System.out.println("Calling here POPULAR");

				break;
			}
			case DealViewerPageFragment.MOST_RECENT_PAGE_ID:{
				Collections.sort(returnList,mostRecentListComparator);
				
				System.out.println("Calling here MOST RECENT");

				break;
			}
			case DealViewerPageFragment.NEAR_BY_PAGE_ID:{
				Collections.sort(returnList,nearByListComparator);
				
				System.out.println("Calling here NEAR BY");

				break;
			}
			case DealViewerPageFragment.END_SOON_PAGE_ID:{
				Collections.sort(returnList,endSoonListComparator);
				
				System.out.println("Calling here END SOON");

				break;
			}
		}
		return returnList;
	}
	private Comparator<Deal> endSoonListComparator = new  Comparator<Deal>(){

		@Override
		public int compare(Deal dealOne, Deal dealTwo) {
			return dealOne.getEndTime().compareTo(dealTwo.getEndTime());
		}
		
	};
	private Comparator<Deal> popularListComparator = new  Comparator<Deal>(){

		@Override
		public int compare(Deal dealOne, Deal dealTwo) {
			return Integer.valueOf(dealTwo.getFeedback().getScore()).compareTo(Integer.valueOf(dealOne.getFeedback().getScore()));
		}
		
	};
	private Comparator<Deal> mostRecentListComparator = new  Comparator<Deal>(){

		@Override
		public int compare(Deal dealOne, Deal dealTwo) {
			return dealOne.getStartTime().compareTo(dealTwo.getStartTime());
		}
		
	};
	private Comparator<Deal> nearByListComparator = new  Comparator<Deal>(){

		@Override
		public int compare(Deal dealOne, Deal dealTwo) {
			return Double.valueOf(dealOne.getDistance()).compareTo(Double.valueOf(dealTwo.getDistance()));
		}
		
	};
	public ArrayList<Deal> getDealList() {
		return fakedeals;
	}
	public void setDealList(ArrayList<Deal> dealList) {
		this.dealList = dealList;
	}

	public Deal getSelectedDeal() {
		return selectedDeal;
	}

	public void setSelectedDeal(Deal selectedDeal) {
		this.selectedDeal = selectedDeal;
	}
}
