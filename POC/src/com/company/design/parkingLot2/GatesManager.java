package com.company.design.parkingLot2;

import com.company.design.parkingLot2.model.Gates;
import com.company.design.parkingLot2.model.Ticket;
import com.company.design.parkingLot2.payments.PaymentManager;
import com.company.design.parkingLot2.pricing.PricingManager;

import java.util.Date;

public class GatesManager {

    TicketManager ticketManager;
    PaymentManager paymentManager;
    PricingManager pricingManager;
    Gates gates;

    Ticket generateTicket(String type, int vehicleId, int gateId) {
        return ticketManager.generateTicket();
    }

    Ticket getTicketdetails(int id) {
        return ticketManager.getTicket(id);
    }

    boolean collectPayment(int id, String paymentType, String pricingMechanism, int userAmount) {
       Ticket ticket =  ticketManager.getTicket(id);
       int price = pricingManager.getPrice(pricingMechanism,ticket);
       ticket.setExitTime(new Date());
       paymentManager.acceptPayment(paymentType, price, userAmount);
       return true;
    }

    //gates and vehcile allowed
}
