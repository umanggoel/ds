package com.company.design.parkingLot2;

import com.company.design.parkingLot2.model.Ticket;

public class PakingLot {

     SpotsManager spotsManager;
     GatesManager gatesManager;

     boolean checkAvailability(String vehicleType) {
        return spotsManager.isSpotAvailable(vehicleType);
     }

     Ticket generateTicket(String type, int vehicleId, int gateId) throws Exception{
         if(spotsManager.reserveSpot(type)) {
             return gatesManager.generateTicket(type, vehicleId, gateId);
         }
         throw new Exception("Ticket cannot be generated, Parking is full");
     }

     boolean collectPayment(int ticketId, String paymentType, String pricingMechanism, int userAmount){
         Ticket ticket = gatesManager.getTicketdetails(ticketId);
         gatesManager.collectPayment(ticketId, paymentType, pricingMechanism, userAmount);
         spotsManager.releaseSpot(ticket.getVehicle().getVehicletype());
         return true;
     }
}
