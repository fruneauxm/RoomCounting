package com.mongodb.models;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;

public class ModelConverter {
	
	public static Room toRoom(Document doc) {
		Room r = new Room();
		r.setRoomID(doc.getObjectId("_id").toHexString());
		r.setName((String)doc.get("roomName"));
		r.setCapacity((String) doc.get("capacity"));
		return r;
	}
	
	
	public static Session toSession(Document doc) {
		Session s = new Session();
		s.setSessionID(doc.getObjectId("_id").toHexString());
		s.setSessionName((String)doc.get("sessionName"));
		s.setSessionNumber((String)doc.get("sessionID"));
		s.setSpeaker((String)doc.get("speakerName"));
		s.setTimeSlot((String)doc.get("speakerName"));
		s.setRoom((String)doc.get("roomId"));
		return s;
	}
	
	public static TimeSlot toTimeSlot(Document doc) {
		TimeSlot t = new TimeSlot();
		t.setTimeSlotID(doc.getObjectId("_id").toHexString());
		t.setStartTime((String)doc.get("startTime"));
		t.setEndTime((String)doc.get("endTime"));
		return t;
	}
}
