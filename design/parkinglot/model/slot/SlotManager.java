package design.parkinglot.model.slot;

import design.parkinglot.exceptions.FreeSlotNotAvailableException;
import design.parkinglot.exceptions.InvalidInputException;
import design.parkinglot.exceptions.SlotsCapacityExceededException;
import design.parkinglot.exceptions.VehicleNotParkedInParking;

import java.util.Optional;

public class SlotManager {
    DefaultSlotStrategy slotStrategy;
    Slots slots;

    public SlotManager(DefaultSlotStrategy slotStrategy, Slots slots) {
        this.slotStrategy = slotStrategy;
        this.slots = slots;
    }

    public void addSlots(int slotsToAdd) throws SlotsCapacityExceededException {
        slotStrategy.addSlots(slotsToAdd);
    }

    public void removeSlots(int numSlots) throws InvalidInputException {
        slotStrategy.removeSlots(numSlots);
    }

    public Slot nextAvailableSlot() throws FreeSlotNotAvailableException {
        return slotStrategy.nextAvailableSlot();
    }

    public void bookSlot(Vehicle vehicle) throws FreeSlotNotAvailableException {
        Slot slot = slotStrategy.nextAvailableSlot();
        slot.setParkedCar(vehicle);
        slots.updateSlot(slot);
    }

    public void setSlotFree(Vehicle vehicle) throws VehicleNotParkedInParking {
        Optional<Slot> slot = slots.getSlotByVehicleNumber(vehicle.getRegistrationNumber());
        if(slot.isPresent())
            slots.updateSlot(slot.get());
        throw new VehicleNotParkedInParking();

    }
}
