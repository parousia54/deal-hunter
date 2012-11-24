package src.com.pinkdroid.dealhunter.util;

import java.io.File;
import java.util.Date;

import com.google.gson.Gson;
import com.mongodb.DBObject;

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

	public static Deal jsonToDeal(DBObject next) {
		// String id;
		// String dealTitle;
		// String dealDescription;
		// File dealImage;
		// Date dealStartDate;
		// Date dealEndDate;
		// int dealScore; // similar to reddit upvote/downvote score
		// String businessId;

		Deal deal = new Deal();
		deal.setDealTitle((String)next.get("dealTitle"));
		deal.setDealDescription((String)next.get("dealDescription"));
		deal.setDealStartDate(((Date)next.get("dealStartDate")));
		deal.setDealEndDate(((Date)next.get("dealEndDate")));
		deal.setDealScore((int) next.get("dealScore"));
		deal.setDealImage((File) next.get("dealImage"));
		
		return deal;
	}

}
