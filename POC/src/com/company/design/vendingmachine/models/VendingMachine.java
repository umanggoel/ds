package com.company.design.vendingmachine.models;

public class VendingMachine {

    private int collectedCash;
    private StateEnum state;

    public void updateCollectedCash(int amount) {
        this.collectedCash = this.collectedCash+amount;
    }

    public StateEnum getState() {
        return state;
    }

    public void setState(StateEnum state) {
        this.state = state;
    }

    public void reset(){

    }
}
