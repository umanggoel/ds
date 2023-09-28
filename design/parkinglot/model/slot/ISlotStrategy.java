package design.parkinglot.model.slot;

import design.parkinglot.exceptions.FreeSlotNotAvailableException;
import design.parkinglot.exceptions.InvalidInputException;
import design.parkinglot.exceptions.SlotsCapacityExceededException;

public interface ISlotStrategy {
    public void addSlots(int slotsToAdd) throws SlotsCapacityExceededException;
    public void removeSlots(int numSlots) throws InvalidInputException;
    public Slot nextAvailableSlot() throws FreeSlotNotAvailableException;
}
