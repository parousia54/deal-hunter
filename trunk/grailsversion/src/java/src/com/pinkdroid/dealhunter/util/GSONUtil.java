package src.com.pinkdroid.dealhunter.util;

import com.google.gson.Gson;
import src.com.pinkdroid.dealhunter.model.Business;

public class GSONUtil {
	
	static Gson gson;
	public static String UsertoJSON(Business obj)
	{
		String json = gson.toJson(obj);
		return json;
	}

}
