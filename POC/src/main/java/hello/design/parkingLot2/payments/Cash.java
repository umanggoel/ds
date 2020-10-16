package com.company.design.parkingLot2.payments;

public class Cash implements PaymentMechanisms {
    @Override
    public void acceptPayment(int price, int userAmount) {
        if(userAmount - price > 0) {
            System.out.println("dispense remaining cash");
        }
    }
}
