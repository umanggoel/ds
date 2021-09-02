package com.company.design.vendingmachine.payment;

import com.company.design.vendingmachine.payment.PaymentMechanism;

import java.util.Map;

public class PaymentMechanismManager {

    Map<String, PaymentMechanism> paymentMechanisms;

    public PaymentMechanism getPaymentMechanism(String type) {
        if (type.equals("CARD")) return paymentMechanisms.get("CARD");
        if (type.equals("CASH")) return paymentMechanisms.get("CASH");
        return null;
    }
}
