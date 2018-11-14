package com.mongodb.utilities;


import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.models.ModelConverter;
import com.mongodb.models.*;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

public class Util {
	
	private MongoCollection col;
	
	public Util(com.mongodb.client.MongoClient mongo, String collection) {
		this.col = mongo.getDatabase("Database").getCollection(collection);
	}
	
	public List<Room> readAllRooms(){
		List<Room> rooms = new ArrayList<Room>();
		MongoCursor<Document> cursor = col.find().iterator();
		while(cursor.hasNext()) {
			Document doc = cursor.next();
			Room r = ModelConverter.toRoom(doc);
			rooms.add(r);
		}
		
		
		return rooms;
	}
	
	public List<Session> readAllSessions(){
		List<Session> sessions = new ArrayList<Session>();
		MongoCursor<Document> cursor = col.find().iterator();
		while(cursor.hasNext()) {
			Document doc = cursor.next();
			Session s = ModelConverter.toSession(doc);
			sessions.add(s);
		}
		
		
		return sessions;
	}
	
	public List<TimeSlot> readAllTimeSlots(){
		List<TimeSlot> timeslots = new ArrayList<TimeSlot>();
		MongoCursor<Document> cursor = col.find().iterator();
		while(cursor.hasNext()) {
			Document doc = cursor.next();
			TimeSlot t = ModelConverter.toTimeSlot(doc);
			timeslots.add(t);
		}
		
		
		return timeslots;
	}

}
