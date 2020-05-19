package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Branch {

	private String name;
	private String city;
	private Map<VehicleType, List<Vehicle>> vehicles = new HashMap<>();
	private int branchId;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Map<VehicleType, List<Vehicle>> getVehicles() {
		return vehicles;
	}
	public void setVehicles(Map<VehicleType, List<Vehicle>> vehicles) {
		this.vehicles = vehicles;
	}
	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	
	public void addVehicle(Vehicle v) {
		if(v.getType() == null) {
			return;
		}
		List<Vehicle> t = vehicles.get(v.getType());
		if(t == null) {
			t = new ArrayList<>();
		}
		t.add(v);
		vehicles.put(v.getType(), t);
	}
	
}
