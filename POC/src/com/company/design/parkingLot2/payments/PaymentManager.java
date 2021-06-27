package com.company.design.parkingLot2.payments;

public class PaymentManager {

    PaymentMechanismResolver tariffStrategyManager;

    public void acceptPayment(String type, int price, int userAmount) {
        tariffStrategyManager.getTariffStrategy(type).acceptPayment(price, userAmount);
    }
}
