package service;

import models.Branch;
import models.FlipKar;
import models.Vehicle;

public class FlipKarManager {

	public void addBranch(FlipKar flipKar, Branch b) {
		flipKar.addBranch(b);
	}
	
	public void addVehicle(FlipKar flipKar, int branchId,Vehicle vehicle) {
		flipKar.getBranch(branchId).addVehicle(vehicle);
	}
	
}
