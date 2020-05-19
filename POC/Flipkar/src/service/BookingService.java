package service;

import java.util.Map;
import java.util.Map.Entry;

import models.Branch;
import models.FlipKar;
import models.VehicleType;

public class BookingService {

	FlipKarManager m = new FlipKarManager();
	BookingStrategyResolver s=new BookingStrategyResolver();
	BranchManagerService bs = new BranchManagerService();
	BookingStrategy b;
	
	public void bookVehicle(FlipKar k,VehicleType type, int start, int end) {
		b = s.resolveBookingStrategy(start, end);
		Branch result = b.bookVehicle(k, start, end,type);
		
		if(result == null) {
			System.out.println("No vehicle Available");
		}else {
			System.out.println("vehcile is Available for branch:"+result.getName());
		}
		
	}
	
	public void printAvailability(FlipKar k, int start, int end) {
		Map<Integer,Branch> branches = k.getBranches(); 
		for(Entry<Integer, Branch> e: branches.entrySet()) {
			System.out.println(e.getValue().getName());
			Map<VehicleType, Double> temp = bs.getAvailableVehicleofBranch(e.getValue(), start, end);
			for(Entry<VehicleType, Double> e1 : temp.entrySet()) {
				if(e1.getValue() == null) {
					System.out.println("Vehicle of type: "+ e1.getKey()+" is not available");
				}else {
					System.out.println("Vehicle of type: "+ e1.getKey()+" is  available at price"+ e1.getValue());
				}
			}
		}
	}
}
