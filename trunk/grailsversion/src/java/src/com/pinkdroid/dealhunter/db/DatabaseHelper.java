package src.com.pinkdroid.dealhunter.db;

import java.io.File;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import src.com.pinkdroid.dealhunter.model.Business;
import src.com.pinkdroid.dealhunter.model.Deal;
import src.com.pinkdroid.dealhunter.util.DataUtil;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.util.JSON;

public class DatabaseHelper {
	
	private Mongo mongo;
	private DB db;
	DBCollection businessCollection;
	DBCollection dealCollection;
	DBCursor cursor;
	private boolean auth;
	
	public DatabaseHelper() {
		try {
			mongo = new Mongo("localhost", 27017);
			db = mongo.getDB("deal-hunter-db");
			auth = db.authenticate("pink", "dr0!d".toCharArray());
			if (auth) {
				businessCollection = db.getCollection("business");
				dealCollection = db.getCollection("deals");
			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (MongoException e) {
			e.printStackTrace();
		}

	}
	
	public boolean registerUser(Business business)
	{
		File businessImage = business.getBusinessImage();
//		business.setBusinessImageURL(DataUtil.saveImage(businessImage, "Business", business.getUsername()));
		
		DBObject dbObject = (DBObject)JSON.parse(DataUtil.businesstoJSON(business));
		businessCollection.insert(dbObject);
		return true;
	}
	
	public boolean createDeal(Deal deal)
	{
		DBObject dbObject = (DBObject)JSON.parse(DataUtil.dealToJSON(deal));
		dealCollection.insert(dbObject);
		return true;
	}
	public boolean deleteDeal(String _id)
	{
		DBObject obj = new BasicDBObjectBuilder().add("_id", "_id").get();
		if(obj != null)
		{
			dealCollection.remove(obj);
			return true;
		}
		return false;
	}
	public List<Deal> getDealsforBusiness(String businessId)
	{
		DBObject searchById = new BasicDBObject("businessId", new ObjectId(businessId));
		DBCursor found = dealCollection.find(searchById);
		List<Deal> dealList = new ArrayList<Deal>();
		while(found.hasNext())
		{
			dealList.add(DataUtil.dbObjectToDeal(found.next()));
		}
		return dealList;
		
	}

}
