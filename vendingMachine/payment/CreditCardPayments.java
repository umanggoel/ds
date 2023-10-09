package vendingMachine.payment;

public class CreditCardPayments implements PaymentMechanism {

    @Override
    public boolean collectPayment(double amount) {
        return false;
    }

    @Override
    public boolean returnChange(double amount) {
        return false;
    }
}
