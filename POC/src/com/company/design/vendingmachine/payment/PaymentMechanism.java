package com.company.design.vendingmachine.payment;

import com.company.design.vendingmachine.exceptions.PaymentFailedException;

public interface PaymentMechanism {

    void acceptPayment(int itemAmount, int userAmount) throws PaymentFailedException;

}
