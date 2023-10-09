package vendingMachine;


import vendingMachine.payment.PaymentManager;
import vendingMachine.payment.PaymentMode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MachineManager {
    Map<Integer, Machine> machines = new HashMap<>();
    SlotManager slotManager = new SlotManager();

    PaymentManager paymentManager = new PaymentManager();


    public Machine getMachine(Integer id) {
       return machines.get(id);
    }

    public Integer addMachine() {
        Machine  m = new Machine();
        m.setId(123);
        machines.put(m.getId(), m);
       // move it to other method m.setState(State.Ready);
        return m.getId();

    }

    public void collectPayment(Integer machineId, Double amount, PaymentMode mode, double price) {
        Machine m = machines.get(machineId);
        if(m == null){
            return;
        }
        boolean paymentCollected = paymentManager.collectPayment(mode, amount);
        if(paymentCollected){
            m.setFunds(m.getFunds() + amount);
        }else{
            System.out.println("Payment couldn't be collected");
        }

    }

    public void updateMachineState(Integer machineId, State state){
        machines.get(machineId).setState(state);
    }

    public void addSlot(Integer machineId, @org.jetbrains.annotations.NotNull Slot slotBO) {
        Machine m = machines.get(machineId);
        m.setState(State.Notready);
        Slot generatedSlot =  slotManager.generateSlot(slotBO.getQuantity(),slotBO.getDetails(),slotBO.getPrice(),slotBO.getId());
        m.getSlots().put(slotBO.getId(), generatedSlot);
        m.setState(State.Ready);
    }

    public Map<Integer, Slot > getSlotDetails(Integer machineId){
        return machines.get(machineId).getSlots();
    }

    public void updateSlot(Integer machineId,Integer slotId, Slot slot) {
        Machine m = machines.get(machineId);
        m.setState(State.Notready);
        Slot existingSlot = m.getSlots().get(slotId);
        slotManager.updateSlot(existingSlot,slot);
        m.setState(State.Ready);
    }
    public void reset(Integer machineId){
        Machine m = machines.get(machineId);
        m.setState(State.Notready);
        m.setFunds(0.0);
        Set<Integer> set = machines.keySet();
        for(Integer i: set) {
            slotManager.resetSlot(m.getSlots().get(i));
        }
        m.setState(State.Ready);
    }

    public Boolean dispenseItem(Integer machineId, Integer slotId, Double paidAmount, PaymentMode mode) {
        if(machines.get(machineId) == null) {
            return false;
        }

        if(machines.get(machineId).getState() != State.Ready ){
            return false;
        }

        updateMachineState(machineId, State.Processing);

        Machine m = machines.get(machineId);
        Double price = m.getSlots().get(slotId).price;
        int quantity = m.getSlots().get(slotId).getQuantity();
        collectPayment(machineId, paidAmount, mode, price);

        if(quantity <= 0 ) {
            System.out.println("insufficient items");
            returnChange(machineId, paidAmount, mode);
            return false;
        }

        if(paidAmount < price) {
            System.out.println("insufficient funds");
            returnChange(machineId, paidAmount, mode);
            return false;

        }

        if(paidAmount > price){
            System.out.println("returning change");
            boolean status = returnChange(machineId, paidAmount-price, mode);
            if(!status) {
                return false;
            }
        }

        m.getSlots().get(slotId).setQuantity(quantity-1);

        updateMachineState(machineId,State.Ready);
        return true;
    }

    private boolean returnChange(Integer machineId, double v, PaymentMode mode) {
        Machine m = machines.get(machineId);
        m.setFunds(m.getFunds()-v);
        paymentManager.returnPayment(mode,m.getFunds()-v );
        System.out.println("Change returned");
        return true;
    }

}
