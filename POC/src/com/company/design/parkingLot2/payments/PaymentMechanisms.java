package com.company.design.parkingLot2.payments;

public interface PaymentMechanisms {

    void acceptPayment(int price, int userAmount);
}
