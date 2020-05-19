package com.service.models;

import java.sql.Timestamp;

public class RateCounter {
	private int count;
	private Timestamp timestamp;
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	
}

