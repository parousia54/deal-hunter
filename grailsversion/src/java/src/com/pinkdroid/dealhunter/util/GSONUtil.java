package src.com.pinkdroid.dealhunter.util;

import java.io.File;
import java.util.Date;

import src.com.pinkdroid.dealhunter.model.Address;
import src.com.pinkdroid.dealhunter.model.Business;
import src.com.pinkdroid.dealhunter.model.Deal;

import com.google.gson.Gson;
import com.mongodb.DBObject;

public class GSONUtil {

	static Gson gson = new Gson();

	public static String businesstoJSON(Business obj) {
		String json = gson.toJson(obj);
		return json;
	}

	public static String dealToJSON(Deal deal) {
		String json = gson.toJson(deal);
		return json;
	}

	public static Deal dbObjectToDeal(DBObject next) {
		Deal deal = new Deal();
		deal.setDealTitle((String) next.get("dealTitle"));
		deal.setDealDescription((String) next.get("dealDescription"));
		deal.setDealStartDate(((Date) next.get("dealStartDate")));
		deal.setDealEndDate(((Date) next.get("dealEndDate")));
		deal.setDealScore((int) next.get("dealScore"));
		deal.setDealImage((File) next.get("dealImage"));

		return deal;
	}

	public static Business dbObjectToBusiness(DBObject next) {
		Business business = new Business();
		business.setUsername((String) next.get("username"));
		business.setVerified((boolean) next.get("isVerfied"));
		business.setBusinessCategory((String) next.get("businessCategory"));
		business.setBusinessImage((File)next.get("bussinessImage"));
		business.setBusinessPhone((String)next.get("businessPhone"));
		
		Address bAddress = new Address();
		DBObject address = (DBObject) next.get("businessAddress");
		bAddress.setPostCode((String) address.get("postCode"));
		bAddress.setState((String) address.get("state"));
		bAddress.setStreetName((String) address.get("streetName"));
		bAddress.setStreetNumber((String) address.get("streetNumber"));
		bAddress.setSuburb((String) address.get("suburb"));
		
		business.setBusinessAddress(bAddress);
		
		return business;

	}

}
