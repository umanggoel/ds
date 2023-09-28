package design.parkinglot.model.Payment;

import design.parkinglot.exceptions.BalanceNotAvailableException;

public class CardPayment implements IPayment{

    private int currentBalance = 1000;
    @Override
    public void processPayment(int amount) throws BalanceNotAvailableException {
        // Deduct money by calling actual payment-service which inturn will call bank

        if(currentBalance<amount)
            throw new BalanceNotAvailableException();
        currentBalance -= amount;
    }

    @Override
    public Boolean validate(int amount) {
        if(amount>10)
            return true;
        return false;
    }
}
