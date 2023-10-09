package vendingMachine;

import vendingMachine.payment.PaymentMode;

public class VendingMachine {

    /*
    emulate a physical vending machine
    1. mahine has slots
    2. slot me has  a capacity of items
    3. available items
    4. price
    5. payment and dispense
    6 collect funds and reset.
     */
    static MachineManager machineManager = new MachineManager();

    public static void main(String[] args) {
        Integer id = machineManager.addMachine();
        Slot s1 =  new Slot();
        s1.setDetails("Chochlate");
        s1.setPrice(10.0);
        s1.setQuantity(10);
        s1.setId(123);
        Slot s2 =  new Slot();
        s2.setDetails("Juice");
        s2.setPrice(20.0);
        s2.setQuantity(10);
        s2.setId(124);
        Slot s3 =  new Slot();
        s3.setDetails("Chips");
        s3.setPrice(10.0);
        s3.setQuantity(1);
        s3.setId(125);
        machineManager.addSlot(id, s1);
        machineManager.addSlot(id, s2);
        machineManager.addSlot(id, s3);

        machineManager.reset(id);
        Boolean dispensed = machineManager.dispenseItem(123, 125,10.0, PaymentMode.CASH);
        if(!dispensed) {
            System.out.println("Item cannot be dispensed");
        } else{
            System.out.println("Item dispensed");

        }

        dispensed = machineManager.dispenseItem(123, 125,10.0, PaymentMode.CASH);
        if(!dispensed) {
            System.out.println("Item cannot be dispensed");
        } else{
            System.out.println("Item dispensed");

        }

    }
}
