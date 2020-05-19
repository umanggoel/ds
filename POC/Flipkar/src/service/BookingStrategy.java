package service;

import models.Branch;
import models.FlipKar;
import models.VehicleType;

public interface BookingStrategy {
	
	public Branch bookVehicle(FlipKar flip, int start, int end, VehicleType type);

}
