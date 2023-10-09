package vendingMachine.payment;

import java.util.HashMap;
import java.util.Map;

public class PaymentManager {

    Map<PaymentMode, PaymentMechanism> paymentMechanismMap = new HashMap<>();

    public PaymentManager() {
        paymentMechanismMap.put(PaymentMode.CASH, new Cashpayments());
        paymentMechanismMap.put(PaymentMode.CreditCard, new CreditCardPayments());
    }
    public boolean collectPayment(PaymentMode mode, double paidAmount) {
        paymentMechanismMap.get(mode).collectPayment(paidAmount);
        return true;
    }

    public boolean returnPayment(PaymentMode mode, double amount) {
        paymentMechanismMap.get(mode).returnChange(amount);
        return true;
    }
}
