package com.mongodb.models;

public class TimeSlot {
	
	private String timeSlotID;
	private String startTime;
	private String endTime;
	
	public void setTimeSlotID(String id) {
		timeSlotID = id;
	}
	public String getTimeSlotID() {
		return timeSlotID;
	}
	
	public void setStartTime(String time) {
		startTime = time;
	}
	
	public void setEndTime(String time) {
		endTime = time;
	}
	
	public String getStartTime() {
		return startTime;
	}
	public String getEndTime() {
		return endTime;
	}

}
