package com.pinkdroid.dealhunter.db;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.util.JSON;
import com.pinkdroid.dealhunter.model.User;
import com.pinkdroid.dealhunter.util.GSONUtil;

public class DatabaseHelper {
	
	private Mongo mongo;
	private DB db;
	DBCollection collection;
	DBCursor cursor;
	private boolean auth;
	
	public DatabaseHelper() {
		try {
			mongo = new Mongo("localhost", 27017);
			db = mongo.getDB("deal-hunter-db");
			auth = db.authenticate("pink", "dr0!d".toCharArray());
			if (auth) {
				collection = db.getCollection("dummyColl");
			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (MongoException e) {
			e.printStackTrace();
		}

	}
	
	public boolean registerUser(User user)
	{
		DBObject dbObject = (DBObject)JSON.parse(GSONUtil.UsertoJSON(user));
        collection.insert(dbObject);
        return true;
	}
	
	


}
