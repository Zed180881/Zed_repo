package sia.springpizza.service;

import sia.springpizza.PaymentException;

/**
 * Simple payment processor implementation.
 * <p>
 * Shown in brief on page 606, but fleshed out here with a dummy implementation
 * that declines payment for any amount over $20.
 *
 * @author wallsc
 */
public class PaymentProcessor {
    public PaymentProcessor() {
    }

    public void approveCreditCard(String creditCardNumber, String expMonth,
                                  String expYear, float amount) throws PaymentException {
        if (amount > 20.00) {
            throw new PaymentException();
        }
    }
}
