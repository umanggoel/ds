package com.company.design.vendingmachine.models;

import java.util.Map;

public class Inventory {
    private Map<String, Item> itemDetails;
    private Map<String, Integer> quantityMap;

    public Item getItemDetails(String code){
        return null;
    }

    public int getItemPrice(String code) {
        return 0;
    }

    public void addItems(String code, Item itemDetails, int quantity){

    }

    public void reset(Map<String, Item> items,Map<String, Integer> quantityMap ){
        itemDetails = items;
        this.quantityMap = quantityMap;
    }

    public Item dispatchItem(String code) {
        quantityMap.put(code, quantityMap.get(code)-1);
        return null;
    }
}
