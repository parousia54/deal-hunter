package src.com.pinkdroid.dealhunter.db;

import java.net.UnknownHostException;

import src.com.pinkdroid.dealhunter.model.Business;
import src.com.pinkdroid.dealhunter.model.Deal;
import src.com.pinkdroid.dealhunter.util.GSONUtil;

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
				businessCollection = db.getCollection("deals");
			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (MongoException e) {
			e.printStackTrace();
		}

	}
	
	public boolean registerUser(Business business)
	{
		DBObject dbObject = (DBObject)JSON.parse(GSONUtil.businesstoJSON(business));
		businessCollection.insert(dbObject);
		return true;
	}
	
	public boolean createDeal(Deal deal)
	{
		DBObject dbObject = (DBObject)JSON.parse(GSONUtil.dealToJSON(deal));
		dealCollection.insert(dbObject);
		return true;
	}
	public boolean deleteDeal(String _id)
	{
		DBObject obj = new BasicDBObjectBuilder().add("_id", "myid").get();
		if(obj != null)
		{
			dealCollection.remove(obj);
			return true;
		}
		return false;
		
	}


}
