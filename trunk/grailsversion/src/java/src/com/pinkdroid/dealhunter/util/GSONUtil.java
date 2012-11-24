package src.com.pinkdroid.dealhunter.util;

import com.google.gson.Gson;
import src.com.pinkdroid.dealhunter.model.Business;
import src.com.pinkdroid.dealhunter.model.Deal;

public class GSONUtil {

	static Gson gson;

	public static String businesstoJSON(Business obj) {
		String json = gson.toJson(obj);
		return json;
	}

	public static String dealToJSON(Deal deal) {
		String json = gson.toJson(deal);
		return json;
	}

}
