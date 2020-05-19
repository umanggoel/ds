package service;

import java.util.Map;

import models.BookingStatus;
import models.Vehicle;

public class VehicleManagerService {

	public boolean checkAvailablity(Vehicle v, int start, int end) {
		Map<Integer, BookingStatus> t = v.getTimeSlots();
		boolean status= true;
		for(int i=start;i<end;i++) {
			if(BookingStatus.BOOKED.equals(t.get(i))) {
				status = false;
			}
		}
		return status;
	}
	
	public void updateStatus(Vehicle v, int start, int end, BookingStatus status) {
		Map<Integer, BookingStatus> t = v.getTimeSlots();
		for(int i=start;i<end;i++) {
			t.put(i, status);
		}
	}
}

