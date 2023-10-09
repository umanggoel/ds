package vendingMachine;

public class SlotManager {

    Slot generateSlot(Integer qty, String details, Double price,Integer id) {
        Slot slot = new Slot();
        slot.setQuantity(qty);
        slot.setDetails(details);
        slot.setPrice(price);
        slot.setId(id);
        slot.defaultPrice = price;
        slot.defaultQty = qty;
        return slot;
    }

    Slot resetSlot(Slot slot) {
        if(slot == null) {
            return null;
        }
        slot.setQuantity(slot.defaultQty);
        slot.setPrice(slot.defaultPrice);
        return slot;
    }

    public void updateSlot(Slot existingSlot, Slot slot) {
        existingSlot.setQuantity(slot.getQuantity());
        existingSlot.setDetails(slot.getDetails());
        existingSlot.setPrice(slot.getPrice());
        existingSlot.defaultPrice = slot.getPrice();
        existingSlot.defaultQty = slot.getQuantity();
    }
}
