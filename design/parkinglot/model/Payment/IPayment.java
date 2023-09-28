package design.parkinglot.model.Payment;

import design.parkinglot.exceptions.BalanceNotAvailableException;

public interface IPayment {
    public void processPayment(int amount) throws BalanceNotAvailableException;
    public Boolean validate(int amount);
}
