package com.company.design.parkingLot2.pricing;

import com.company.design.parkingLot2.model.Ticket;

public interface PricingMechanisms {

    int getPrice(Ticket ticket);
}
