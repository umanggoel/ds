package com.company.design.vendingmachine;

import com.company.design.vendingmachine.exceptions.PaymentFailedException;
import com.company.design.vendingmachine.models.Item;
import com.company.design.vendingmachine.models.StateEnum;
import com.company.design.vendingmachine.models.VendingMachine;

import static com.company.design.vendingmachine.models.StateEnum.NOTREADY;
import static com.company.design.vendingmachine.models.StateEnum.READY;

public class VendingMachineManager {

    private final VendingMachine vendingMachine;
    private final PaymentManager paymentManager;
    private final InventoryManager inventoryManager;

    public VendingMachineManager(com.company.design.vendingmachine.models.VendingMachine vendingMachine, PaymentManager paymentManager, InventoryManager inventoryManager) {
        this.vendingMachine = vendingMachine;
        this.paymentManager = paymentManager;
        this.inventoryManager = inventoryManager;
    }

    public Item displayDetails(String code) {
        return inventoryManager.getItemDetails(code);
    }

    public void dispenseItem(String code, int amount , String strategy) {
        vendingMachine.setState(StateEnum.INFLIGHT);
            int price = inventoryManager.getItemPrice(code);
            if(price == -1) {
                vendingMachine.setState(READY);
                return;
            }
            try {
                paymentManager.collectPayment(strategy, price, amount);
                inventoryManager.dispatchItem(code);
                // receipt print
                vendingMachine.updateCollectedCash(price);
            } catch (PaymentFailedException e) {
                System.out.println("Transaction Failed");// retry mechanism can be there
            }
    }

    public void resetMachine() {
        vendingMachine.setState(NOTREADY);
        vendingMachine.reset();
        inventoryManager.reset();
        vendingMachine.setState(READY);
    }

    public void cancelTransaction() {
        vendingMachine.setState(READY);
    }

}
