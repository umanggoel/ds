package com.company.design.vendingmachine;

import com.company.design.vendingmachine.exceptions.PaymentFailedException;
import com.company.design.vendingmachine.models.Item;
import com.company.design.vendingmachine.models.VendingMachineState;

import static com.company.design.vendingmachine.models.StateEnum.NOTREADY;
import static com.company.design.vendingmachine.models.StateEnum.READY;

public class VendingMachine {

    private final VendingMachineState vendingMachineState;
    private final PaymentManager paymentManager;
    private final InventoryManager inventoryManager;

    public VendingMachine(VendingMachineState vendingMachine, PaymentManager paymentManager,InventoryManager inventoryManager) {
        this.vendingMachineState = vendingMachine;
        this.paymentManager = paymentManager;
        this.inventoryManager = inventoryManager;
    }

    public Item displayDetails(String code) {
        return inventoryManager.getItemDetails(code);
    }

    public void dispenseItem(String code, int amount , String strategy) {
            int price = inventoryManager.getItemPrice(code);
            if(price == -1) {
                return;
            }
            try {
                paymentManager.collectPayment(strategy, price, amount);
                inventoryManager.dispatchItem(code);
                vendingMachineState.updateCollectedCash(price);
            } catch (PaymentFailedException e) {
                System.out.println("Transaction Failed");// retry mechanism can be there
            }
    }

    public void resetMachine() {
        vendingMachineState.setState(NOTREADY);
        vendingMachineState.reset();
        inventoryManager.reset();
        vendingMachineState.setState(READY);
    }

    public void cancelTransaction() {
        vendingMachineState.setState(READY);
    }

}
