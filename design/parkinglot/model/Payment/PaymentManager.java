package design.parkinglot.model.Payment;

import design.parkinglot.exceptions.BalanceNotAvailableException;

public class PaymentManager {
    IPayment iPayment;

    public PaymentManager(IPayment iPayment){
        this.iPayment = iPayment;
    }

    public void deductMoney(int amount) throws BalanceNotAvailableException {
        iPayment.processPayment(amount);
    }
}
