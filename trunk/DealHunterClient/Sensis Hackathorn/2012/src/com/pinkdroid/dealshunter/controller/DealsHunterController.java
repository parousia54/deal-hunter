package com.pinkdroid.dealshunter.controller;

import java.util.ArrayList;
import java.util.Date;

import com.google.android.maps.GeoPoint;
import com.pinkdroid.dealshunter.model.Business;
import com.pinkdroid.dealshunter.model.Deal;
import com.pinkdroid.dealshunter.model.Deal.UserFeedback;

import android.app.Application;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

@SuppressWarnings("deprecation")
public class DealsHunterController extends Application {
	private static DealsHunterController _instance;
	private static LocationManager locationManager;
	public static GeoPoint userCurrGeoPoint;
	public static ArrayList<Deal> fakedeals = new ArrayList<Deal>();
	static {//Parlour Hairdressing, MYERS, DENDY Cinema, Hoyts Cinema, Mai Thai Vietnamese Restaurant
		fakedeals.add(new Deal(0, Business.businesses.get(0), new Date(112, 11, 25, 9, 0), new Date(112, 11, 25, 17, 0), 200, 1, null, new UserFeedback(23, 2), 0, null,
				"50% discount on hair extension. Two year wrranty!"));
		fakedeals.add(new Deal(1, Business.businesses.get(1), new Date(112, 11, 6, 9, 0), new Date(112, 11, 21, 17, 0), 200, 1, null, new UserFeedback(55, 2), 0, null, "$20 Off on all eletrical appliances"));
		fakedeals.add(new Deal(2, Business.businesses.get(2), new Date(112, 11, 2, 9, 0), new Date(112, 11, 25, 17, 0), 200, 1, null, new UserFeedback(200, 0), 0, null, "$11 Ticket for SkyFall every monday"));
		fakedeals.add(new Deal(3, Business.businesses.get(1), new Date(112, 11, 6, 9, 0), new Date(112, 11, 21, 17, 0), 200, 1, null, new UserFeedback(6, 4), 0, null,
				"Buy any two shirts to get the third one FREE*, Hurry up while stocks last"));
		fakedeals.add(new Deal(4, Business.businesses.get(3), new Date(112, 11, 6, 9, 0), new Date(112, 11, 21, 17, 0), 200, 1, null, new UserFeedback(20, 2), 0, null, "$8 Gold Class Movie Ticket on Wednesday"));
		fakedeals.add(new Deal(6, Business.businesses.get(4), new Date(112, 11, 6, 9, 0), new Date(112, 11, 21, 17, 0), 200, 1, null, new UserFeedback(283, 11), 0, null,
				"Spend more than $20 on dinner to get 30% discount"));
		fakedeals.add(new Deal(7, Business.businesses.get(1), new Date(112, 11, 6, 9, 0), new Date(112, 11, 21, 17, 0), 200, 1, null, new UserFeedback(54, 8), 0, null,
				"$40 for Halo4 games"));
	}
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

	public ArrayList<Deal> getDealList() {
		return fakedeals;
	}

	public void setDealList(ArrayList<Deal> dealList) {
		this.dealList = dealList;
	}
}
