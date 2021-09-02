package com.company.design.vendingmachine;

import com.company.design.vendingmachine.exceptions.PaymentFailedException;
import com.company.design.vendingmachine.payment.PaymentMechanism;
import com.company.design.vendingmachine.payment.PaymentMechanismManager;

public class PaymentManager {

    PaymentMechanismManager paymentMechanismManager;

    void collectPayment(String type, int amount, int inserted) throws PaymentFailedException {
        PaymentMechanism p = paymentMechanismManager.getPaymentMechanism(type);
        p.acceptPayment(amount, inserted);
    }
}
