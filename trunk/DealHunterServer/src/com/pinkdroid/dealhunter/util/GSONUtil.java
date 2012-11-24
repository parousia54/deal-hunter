package com.pinkdroid.dealhunter.util;

import com.google.gson.Gson;
import com.pinkdroid.dealhunter.model.User;

public class GSONUtil {
	
	static Gson gson = new Gson();
	public static String UsertoJSON(User obj)
	{
		String json = gson.toJson(obj);
		return json;
	}

}
