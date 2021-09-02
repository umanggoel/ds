package com.company.design.parkingLot2.model;

import java.util.Map;

public class Gates {

    Map<String, Map<Integer, Gate>> gates;

    //check the vechicle allowed

    public boolean isALlowed(String vehicleType, Integer gateId, String gateType) {
        return true;
    }
}
