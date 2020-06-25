package com.company.design.parkinglot.service;

import com.company.design.parkinglot.domain.ParkingFacility;
import com.company.design.parkinglot.domain.ParkingFloor;
import com.company.design.parkinglot.domain.ParkingSpot;

import java.util.Map;

public class ParkingFacilityManagementService {

    Map<String, ParkingFacility> parkingFacilityMap;
    ParkingSpotFactory parkingSpotFactory;

    ParkingFacility getParkingFacility(String id){
        return null;
    }

    public void addParkingFacility(){

    }

    public void removeParkingFacility(String id){

    }

    public void addParkingFloor(String facilityId){

    }

    public void removeParkingFloor(String facilityId){

    }

    public void addParkingSpot(String facilityId, String floorId, String type){
       ParkingFacility facility = getParkingFacility(facilityId);
       ParkingFloor floor = facility.getFloor(floorId);
       ParkingSpot spot = parkingSpotFactory.createParkingSpot(type);
       floor.addParkingSpot(spot,type);
    }

    public void removeParkingSpot(String facilityId, String floorId, String type){
        ParkingFacility facility = getParkingFacility(facilityId);
        ParkingFloor floor = facility.getFloor(floorId);
        floor.removeParkingSpot(type);
    }

}
