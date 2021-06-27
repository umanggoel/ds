package com.company.design.parkingLot2.model;

import java.util.Date;

public class Ticket {

    private int id;
    private Date issueTime;
    private Vehicle Vehicle;
    private Date exitTime;
    private int gateId;

    public int getGateId() {
        return gateId;
    }

    public void setGateId(int gateId) {
        this.gateId = gateId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getIssueTime() {
        return issueTime;
    }

    public void setIssueTime(Date issueTime) {
        this.issueTime = issueTime;
    }

    public com.company.design.parkingLot2.model.Vehicle getVehicle() {
        return Vehicle;
    }

    public void setVehicle(com.company.design.parkingLot2.model.Vehicle vehicle) {
        Vehicle = vehicle;
    }

    public Date getExitTime() {
        return exitTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

}
