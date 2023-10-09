package vendingMachine.payment;

public class Cashpayments implements PaymentMechanism {
    @Override
    public boolean collectPayment(double amount) {
        return true;
    }

    @Override
    public boolean returnChange(double amount) {
        return true;
    }
}
