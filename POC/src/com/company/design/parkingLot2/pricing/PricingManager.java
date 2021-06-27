package com.company.design.parkingLot2.pricing;

import com.company.design.parkingLot2.model.Ticket;

import java.util.Map;

public class PricingManager {

    Map<String, PricingMechanisms> pricingMechanismsMap;

    public int getPrice(String type, Ticket ticket) {
        return pricingMechanismsMap.get(type).getPrice(ticket);
    }
}
