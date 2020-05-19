package models;

import java.util.HashMap;
import java.util.Map;

public class Vehicle {

	private Map<Integer, BookingStatus> timeSlots = new HashMap<>();
	private double basePrice;
	private VehicleType type;
	
	public VehicleType getType() {
		return type;
	}
	
	public void setType(VehicleType type) {
		this.type = type;
	}
	
	
	public Map<Integer, BookingStatus> getTimeSlots() {
		return timeSlots;
	}

	public void setTimeSlots(Map<Integer, BookingStatus> timeSlots) {
		this.timeSlots = timeSlots;
	}

	public double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	public void buildVehicle(int startTime, int endTime,double basePrice) {
		for(int i=startTime;i<=endTime;i++) {
			timeSlots.put(i, BookingStatus.AVAILABLE);
		}
		this.basePrice = basePrice;
	}
	
}
