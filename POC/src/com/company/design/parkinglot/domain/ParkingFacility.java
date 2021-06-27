package com.company.design.parkinglot.domain;

import java.util.Map;

public class ParkingFacility {

    Map<String , ParkingFloor> floors;

    PricingDetails pricingDetails;

   public ParkingFloor availableFloor(ParkingType type){
        return null;
    }

   public  ParkingFloor getFloor(String id){
       return floors.get(id);
    }

}
