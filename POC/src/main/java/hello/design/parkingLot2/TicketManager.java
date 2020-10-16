package com.company.design.parkingLot2;

import com.company.design.parkingLot2.model.Ticket;

import java.util.Map;

public class TicketManager {
    Map<Integer, Ticket> ticketMap;

    Ticket getTicket(int id) {
        return ticketMap.get(id);
    }

    Ticket generateTicket() {
        ticketMap.put(1, new Ticket());
        return null;
    }
}
