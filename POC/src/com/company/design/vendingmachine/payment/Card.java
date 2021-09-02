package com.company.design.vendingmachine.payment;

import com.company.design.vendingmachine.exceptions.PaymentFailedException;

public class Card implements PaymentMechanism {

    @Override
    public void acceptPayment(int amount, int inserted) throws PaymentFailedException {
    }
}
