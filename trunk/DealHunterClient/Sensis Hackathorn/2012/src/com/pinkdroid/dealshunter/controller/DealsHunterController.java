package com.pinkdroid.dealshunter.controller;

import java.util.ArrayList;

import com.google.android.maps.GeoPoint;
import com.pinkdroid.dealshunter.model.Deal;

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

	ArrayList<Deal> dealList = new ArrayList<Deal>();

	public ArrayList<Deal> getDealList() {
		return dealList;
	}

	public void setDealList(ArrayList<Deal> dealList) {
		this.dealList = dealList;
	}
}
