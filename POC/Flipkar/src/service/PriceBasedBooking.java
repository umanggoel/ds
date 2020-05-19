package service;

import java.util.Map;
import java.util.Map.Entry;

import models.Branch;
import models.FlipKar;
import models.VehicleType;

public class PriceBasedBooking implements BookingStrategy{

	FlipKarManager m = new FlipKarManager();
	BranchManagerService bs = new BranchManagerService();
	
	@Override
	public Branch bookVehicle(FlipKar k, int start, int end, VehicleType type) {
		Map<Integer,Branch> branches = k.getBranches(); 
		double minPrice = Integer.MAX_VALUE;
		Branch b = null;
		
		for(Entry<Integer, Branch> e: branches.entrySet()) {
			
			Double price = bs.getAvailableVehicleofBranchOfType(e.getValue(), start, end, type);
			if(price != null) {
				if(price < minPrice) {
					minPrice = price;
					b = e.getValue();
				}
			}
		}
		return b;
	}

}
