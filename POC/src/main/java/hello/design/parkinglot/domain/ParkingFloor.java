package com.company.design.parkinglot.domain;

import java.util.Map;
import java.util.Stack;

public class ParkingFloor {

    String id;
    Map<ParkingType, Stack<ParkingSpot>> spots;

    public int availableParkingSpots(String type){
        return spots.get(type).size();
    }

    public ParkingSpot bookParkingSpot(String type){
        return spots.get(type).pop();
    }

    public void releaseParkingSpot(ParkingSpot parkingSpot,String type){
        spots.get(type).push(parkingSpot);
    }

    public void addParkingSpot(ParkingSpot parkingSpot,String type){
        spots.get(type).push(parkingSpot);
    }

    public void removeParkingSpot(String type){
        spots.get(type).pop();
    }
}
