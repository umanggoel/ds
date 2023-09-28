package design.parkinglot.service;

import design.parkinglot.exceptions.BalanceNotAvailableException;
import design.parkinglot.exceptions.FreeSlotNotAvailableException;
import design.parkinglot.exceptions.VehicleNotParkedInParking;
import design.parkinglot.model.Payment.CardPayment;
import design.parkinglot.model.Payment.PaymentManager;
import design.parkinglot.model.slot.DefaultSlotStrategy;
import design.parkinglot.model.slot.SlotManager;
import design.parkinglot.model.slot.Slots;
import design.parkinglot.model.slot.Vehicle;

public class ParkingService {
    SlotManager slotManager;
    PaymentManager paymentManager;

    public ParkingService() {
        Slots slots = new Slots();
        this.slotManager = new SlotManager(new DefaultSlotStrategy(slots), slots);
        this.paymentManager = new PaymentManager(new CardPayment());
    }

    public void park(Vehicle vehicle) {

        try {
            slotManager.bookSlot(vehicle);
            paymentManager.deductMoney(100);
        } catch (FreeSlotNotAvailableException e) {
            System.out.println("Parking Space is not available");
        } catch (BalanceNotAvailableException e){
            // rollback if payment fails
            try { slotManager.setSlotFree(vehicle);} catch (VehicleNotParkedInParking ex) {
                System.out.println("Given Vehicle is not parked here");
            }
            System.out.println("Low on balance");
        }
        System.out.println("Vehicle parked successfully");
    }

    public void unPark(Vehicle vehicle){
        try {
            slotManager.setSlotFree(vehicle);
        } catch (VehicleNotParkedInParking e) {
            System.out.println("This Vehicle is not parked here");
        }
    }
}
