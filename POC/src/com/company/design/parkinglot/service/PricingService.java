package com.company.design.parkinglot.service;

import com.company.design.parkinglot.domain.ParkingFacility;
import com.company.design.parkinglot.domain.Vehicle;

public class PricingService {

    ParkingFacilityManagementService parkingFacilityManagementService;

    public void calculatePrice(Vehicle vehicle){
        ParkingFacility parkingFacility = parkingFacilityManagementService.getParkingFacility(vehicle.getFacilityId());
    }

    public void modifyPricingModel(String facilityId){

    }

    public void createPricingModel(String facilityId){

    }

}
