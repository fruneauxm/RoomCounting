package com.mongodb.DBInterface;

import java.sql.Time;
import com.mongodb.*;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.*;
import com.mongodb.client.model.Sorts;
import java.util.Arrays;
import org.bson.Document;

public class DatabaseInterface {

	private String DB_NAME = "Database";
	private MongoDatabase db;

	public DatabaseInterface(String url , int port){
		db = getConnection(url , port).getDatabase(DB_NAME);
	}

	public DatabaseInterface(){
		this("localhost" , 27017);
	}

	private static MongoClient getConnection(String url , int port_num) {
        
        MongoClient mongoClntObj = new MongoClient(url, port_num);
        return mongoClntObj;
	}

	/*
	private Block<Document> printBlock = new Block<Document>() {
		@Override
		public void apply(final Document document) {
			return document.toJson();
		}
 	};
	
	public String getRoomJSON(){
		MongoCollection<Document> collection = db.getCollection("Room");
		return collection.find().forEach(printBlock);
	}


	// public int getRoomCapacity() {
	// 	return 0;
	// }

	public String getTimeSlotJSON() {
		MongoCollection<Document> collection = db.getCollection("TimeSlot");
		return collection.find().forEach(printBlock);
	}

	public String getSessionJSON() {
		MongoCollection<Document> collection = db.getCollection("Session");
		return collection.find().forEach(printBlock);
	}

	// public String getSessionName() {
	// 	return "";
	// }

	// public int getSessionNumber() {
	// 	return 0;
	// }

	// public String getSpeakerName() {
	// 	return "";
	// }

	public boolean setRoomName() {
		return false;
	}

	public boolean setRoomCapacity() {
		return false;
	}

	public boolean setTimeSlot() {
		return false;
	}

	public boolean setSessionName() {
		return false;
	}

	public boolean setSessionNumber() {
		return false;
	}

	public boolean setSpeakerName() {
		return false;
	}
	*/
}
