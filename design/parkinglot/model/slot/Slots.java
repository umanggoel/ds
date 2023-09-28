package design.parkinglot.model.slot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Slots {
   private Map<Integer, Slot> slotMap;

    public Slots(){
        slotMap = new HashMap<>();
    }

    public void addSlot(Integer slotNumber){
        slotMap.put(slotNumber, new Slot(slotNumber));
    }

    public void removeSlot(Integer slotNumber) {
        slotMap.remove(slotNumber);
    }

    public List<Slot> getAllSlots(){
        return (List<Slot>) slotMap.values();
    }

    public void updateSlot(Slot slot){
        slotMap.put(slot.getSlotNumber(), slot);
    }

    public Optional<Slot> getSlotByVehicleNumber(int vehicleNumber) {
        return slotMap.values().stream().filter(slt -> slt.getParkedCar().getRegistrationNumber().equals(vehicleNumber)).findFirst();
    }
}
