package com.service.models;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class Hotel {
	
	private String name;
	private Map<Integer, TimeSlot> timeSlotsMap;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Map<Integer, TimeSlot> getTimeSlotsMap() {
		return timeSlotsMap;
	}
	public void setTimeSlotsMap(Map<Integer, TimeSlot> timeSlotsMap) {
		this.timeSlotsMap = timeSlotsMap;
	}
}