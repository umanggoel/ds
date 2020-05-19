package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import models.Branch;
import models.Vehicle;
import models.VehicleType;

public class BranchManagerService {
	
	VehicleManagerService vs = new VehicleManagerService();
	public Map<VehicleType, Double> getAvailableVehicleofBranch(Branch b, int start, int end){
		Map<VehicleType, Double> v = new HashMap<>();
		
		for(Entry<VehicleType,List<Vehicle>> e: b.getVehicles().entrySet()) {
			boolean available = false;
			Double price = null;
			for(Vehicle v1:e.getValue()) {
				if(vs.checkAvailablity(v1, start, end)) {
					available = true;
					price = v1.getBasePrice();
					break;
				}
			}
			if(available) {
				v.put(e.getKey(), price);
			}
		}
		 return v;
	}
	
	public Double getAvailableVehicleofBranchOfType(Branch b, int start, int end, VehicleType type){
		
		for(Entry<VehicleType,List<Vehicle>> e: b.getVehicles().entrySet()) {
			if(type.equals(e.getKey())) {
				for(Vehicle v1:e.getValue()) {
					if(vs.checkAvailablity(v1, start, end)) {
						return v1.getBasePrice();
					}
				}
			}
		}
		 return null;
	}
}
