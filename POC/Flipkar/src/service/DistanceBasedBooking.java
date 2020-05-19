package service;

import models.Branch;
import models.FlipKar;
import models.VehicleType;

public class DistanceBasedBooking  implements BookingStrategy{

	@Override
	public Branch bookVehicle(FlipKar flip, int start, int end, VehicleType type) {
		System.out.println("Method not implemented");
		return null;
	}

}
