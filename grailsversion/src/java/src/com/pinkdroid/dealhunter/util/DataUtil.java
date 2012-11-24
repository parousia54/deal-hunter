package src.com.pinkdroid.dealhunter.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;

import src.com.pinkdroid.dealhunter.model.Address;
import src.com.pinkdroid.dealhunter.model.Business;
import src.com.pinkdroid.dealhunter.model.Deal;

import com.google.gson.Gson;
import com.mongodb.DBObject;

public class DataUtil {

	static Gson gson = new Gson();
	static DateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");

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
        deal.setId((String)next.get("_id").toString());
        deal.setUsername((String)next.get("username"));
		deal.setDealTitle((String) next.get("dealTitle"));
		deal.setDealDescription((String) next.get("dealDescription"));
		
		try {
			deal.setDealStartDate(((Date) formatter.parse((String)next.get("dealStartDate"))));
			deal.setDealEndDate(((Date) formatter.parse((String)(next.get("dealEndDate")))));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		deal.setDealScore((Integer) next.get("dealScore"));
		deal.setDealImage((File) next.get("dealImage"));

		return deal;
	}

	public static Business dbObjectToBusiness(DBObject next) {
		Business business = new Business();
		business.setUsername((String) next.get("username"));
		business.setVerified(next.get("isVerified") != null);
		business.setBusinessCategory((String) next.get("businessCategory"));
		business.setBusinessImage((File)next.get("businessImage"));
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

	public static String saveImage(File businessImage, String type, String filename) {
		String path = "/var/webapps/images/"+type.toLowerCase()+"/"+filename+".jpg";
		
		String prefix = FilenameUtils.getBaseName(businessImage.getName()); 
		String suffix = FilenameUtils.getExtension(businessImage.getName());
		File uploadLocation = new File("/var/webapps/images"+type.toLowerCase());
		File file = null;
		OutputStream output = null;
		java.io.InputStream input = null;
		try {
			file = File.createTempFile(prefix + "-", "." + suffix, uploadLocation);
			input = new java.io.FileInputStream(businessImage);
			output = new FileOutputStream(file);
			IOUtils.copy(input, output);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		    IOUtils.closeQuietly(output);
		    IOUtils.closeQuietly(input);
		}
		return file.getPath();
	}

}
