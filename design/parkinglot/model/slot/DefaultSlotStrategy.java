package design.parkinglot.model.slot;

import design.parkinglot.exceptions.FreeSlotNotAvailableException;
import design.parkinglot.exceptions.InvalidInputException;
import design.parkinglot.exceptions.SlotsCapacityExceededException;
import design.parkinglot.utils.MyConstants;

import java.util.List;

public class DefaultSlotStrategy implements ISlotStrategy {

    Slots slots;

    public DefaultSlotStrategy(Slots slots) {
        this.slots = slots;
    }

    @Override
    public void addSlots(int slotsToAdd) throws SlotsCapacityExceededException {
        if (slotsToAdd >= MyConstants.MAX_CAPACITY)
            throw new SlotsCapacityExceededException();
        for (int i = 0; i < MyConstants.MAX_CAPACITY; i++) {
            slots.addSlot(i);
        }
    }

    @Override
    public void removeSlots(int slotsToRemove) throws InvalidInputException {
        if(slotsToRemove>MyConstants.MAX_CAPACITY)
            throw new InvalidInputException();

        for(int i=0; i<slotsToRemove; i++){
            slots.removeSlot(i);
        }

    }

    @Override
    public Slot nextAvailableSlot() throws FreeSlotNotAvailableException {
        List<Slot> allSlots = slots.getAllSlots();
        for(Slot slt : allSlots){
            if(!slt.isParked())
                return slt;
        }
        throw new FreeSlotNotAvailableException();
    }
}
