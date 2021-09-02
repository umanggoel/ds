package com.company.design.parkingLot2.model;

public class ParkingSpot {

    private int id;

    private String type; // small, medium , big, electric

    private boolean hasCharger;    //isAvailable

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
