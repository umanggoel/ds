package com.company.design.vendingmachine.models;

import java.util.List;
import java.util.Map;

public class Inventory {
    private Map<String, List<Item>> inventory;

    public Item getItemDetails(String code){
        return null;
    }

    public int getItemPrice(String code) {
        return 0;
    }

    public void addItems(String code, Item itemDetails, int quantity){

    }

    public void reset(Map<String, List<Item>> items){
        inventory = items;
    }

    public Item dispatchItem(String code) {
        return null;
    }
}
