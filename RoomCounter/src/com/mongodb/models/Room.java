package com.mongodb.models;

public class Room {
	
	private String roomID;
	private String name;
	private String capacity;
	
	public String getRoomID() {
		return roomID;
	}
	public void setRoomID(String identifier) {
		roomID = identifier;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	

}
