package com.company.design.vendingmachine;

import com.company.design.vendingmachine.exceptions.PaymentFailedException;

public class PaymentManager {

    PaymentMechanismManager paymentMechanismManager;

    void collectPayment(String type, int amount, int inserted) throws PaymentFailedException {
        PaymentMechanism p = paymentMechanismManager.getPaymentMechanism(type);
        p.acceptPayment(amount, inserted);
    }
}
