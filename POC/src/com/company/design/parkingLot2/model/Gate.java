package com.company.design.parkingLot2.model;

import java.util.Set;

public class Gate {

    private int id;
    private String type;
    Set<String> vehiclesAllowed;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
