package src.com.pinkdroid.dealhunter.ws;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

import src.com.pinkdroid.dealhunter.model.Address;
import src.com.pinkdroid.dealhunter.network.NetworkEngine;

public class SensisAPICaller {

	
	private final static String API_URL = "http://api.sensis.com.au/ob-20110511/test/search";
	private final static int TIMEOUT = 10000;

	private final static String CATEGORYID = "categoryId";
	private static final String POSTCODE = "postcode";
	private static final String ROWS = "rows";
	private static final String CONTENT = "content";
	private static final String KEY = "key";
	private static final String[] sensisApiKeys = {"ergdteane92h6u9hycnhkuvy", "26zac3pbk9fdq6ane8cqk3s2"};
	private static int rrIndex=0;
	private static final String QUERY = "query";
	private static final String LOCATION = "location";
	
	private static final int SEARCH_LIMIT = 50;
	private static final int RETRIES = 3;

	private static SensisAPICaller instance;
	
	private SensisAPICaller() {
	}

	public static SensisAPICaller getInstance() {
		if (instance == null)
			instance = new SensisAPICaller();
		return instance;
	}
	
	protected static String getSensisApiKey() {
		rrIndex=(rrIndex+1)%sensisApiKeys.length;
		System.out.println("The key no. "+rrIndex+","+sensisApiKeys[rrIndex]+" is used");
		return sensisApiKeys[rrIndex];
	}
	
	
	public boolean isRegistered(String businessName, Address businessAddress, String businessPhone )
	{
		return false;
	}
}
