package com.company.design.parkingLot2;

import com.company.design.parkingLot2.model.Spots;

public class SpotsManager {

    Spots spot;

    public boolean isSpotAvailable(String vehicleType) {
        return spot.isSpotAvailable(vehicleType);
    }

    public boolean reserveSpot(String vehicleType) {
        return true;
    }

    public boolean releaseSpot(String vehicleType) {
        return true;
    }

    //addSpot

}
