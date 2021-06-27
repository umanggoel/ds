package com.company.design.vendingmachine;

import com.company.design.vendingmachine.exceptions.PaymentFailedException;

public class Cash implements PaymentMechanism {

    @Override
    public void acceptPayment(int itemPrice, int userAmount) throws PaymentFailedException {
        if(userAmount - itemPrice > 0){
            dispenseChange(userAmount - itemPrice);
        }
    }

    public int dispenseChange(int amount) {
        return 0;
    }
}
