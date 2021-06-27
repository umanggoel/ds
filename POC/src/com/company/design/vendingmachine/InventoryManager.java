package com.company.design.vendingmachine;

import com.company.design.vendingmachine.models.Inventory;
import com.company.design.vendingmachine.models.Item;

public class InventoryManager {

    private final Inventory inventory;

    public InventoryManager(Inventory inventory) {
        this.inventory = inventory;
    }

    public Item getItemDetails(String code) {
        return null;
    }


    public int getItemPrice(String code) {
        return 0;
    }

    public Item dispatchItem(String code) {
        return null;
    }

    public void reset() {
    }


}
