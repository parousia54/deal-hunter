package src.com.pinkdroid.dealhunter.ws;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.message.BasicNameValuePair;

import src.com.pinkdroid.dealhunter.model.Address;
import src.com.pinkdroid.dealhunter.network.NetworkEngine;

import com.amazonaws.util.json.JSONArray;
import com.amazonaws.util.json.JSONObject;

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
		NetworkEngine nengine = NetworkEngine.getInstance();
		Hashtable<String, String> headers = new Hashtable<String, String>();
		ArrayList<NameValuePair> parameters = new ArrayList<NameValuePair>();
		
		parameters.add(new BasicNameValuePair(KEY, getSensisApiKey()));
		parameters.add(new BasicNameValuePair(QUERY, ""+businessName));
		parameters.add(new BasicNameValuePair(LOCATION, ""+businessAddress.getSuburb()));
		parameters.add(new BasicNameValuePair(POSTCODE, ""+businessAddress.getPostCode()));
		
		
		try {

			byte[] bytes = null;

			for (int i = 0; i < RETRIES && bytes == null; i++)
				bytes = nengine.getRawPair(API_URL, headers, parameters,
					TIMEOUT);

			if (bytes != null) {
				String result = new String(bytes);
				JSONObject json = new JSONObject(result);
				JSONArray array = json.getJSONArray("results");
				
				System.out.println("111");
				if (array.length() == 0) return false;

				System.out.println("222");
				for (int i = 0; i < array.length(); i++)
				{
					System.out.println("333");
					JSONObject row = array.getJSONObject(i);
					if (row == null)
						return false;

					System.out.println("444");
					JSONObject prime = row.getJSONObject("primaryContacts");
					if (prime == null) 
						continue;

					System.out.println("555");
					String type = prime.getString("type");
					String phone = "";
					if("PHONE".matches(type))
					{
						phone = prime.getString("value");
					}
					if(phone.matches(businessPhone))
					{
						return true;
					}
				}
				return false;
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// http://api.sensis.
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
