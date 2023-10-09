package vendingMachine.payment;

public interface PaymentMechanism {

    boolean collectPayment(double amount);
    boolean returnChange(double amount);
}
