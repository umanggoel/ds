package com.company.design.parkinglot.domain;

public class ParkingSpot {

    String id;
    ParkingType type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ParkingType getType() {
        return type;
    }

    public void setType(ParkingType type) {
        this.type = type;
    }
}
