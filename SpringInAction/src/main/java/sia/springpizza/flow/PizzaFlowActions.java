package sia.springpizza.flow;

import static sia.springpizza.domain.PaymentType.*;
import static org.apache.log4j.Logger.*;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sia.springpizza.domain.CashOrCheckPayment;
import sia.springpizza.domain.CreditCardPayment;
import sia.springpizza.domain.Customer;
import sia.springpizza.domain.Order;
import sia.springpizza.domain.Payment;
import sia.springpizza.domain.PaymentDetails;
import sia.springpizza.service.CustomerNotFoundException;
import sia.springpizza.service.CustomerService;

@Component
public class PizzaFlowActions {
    private static final Logger LOGGER = getLogger(PizzaFlowActions.class);

    public Customer lookupCustomer(String phoneNumber)
            throws CustomerNotFoundException {
        Customer customer = customerService.lookupCustomer(phoneNumber);
        if (customer != null) {
            return customer;
        } else {
            throw new CustomerNotFoundException();
        }
    }

    public void addCustomer(Customer customer) {
        LOGGER.warn("TODO: Flesh out the addCustomer() method.");
    }

    public Payment verifyPayment(PaymentDetails paymentDetails) {
        Payment payment = null;
        if (paymentDetails.getPaymentType() == CREDIT_CARD) {
            payment = new CreditCardPayment();
        } else {
            payment = new CashOrCheckPayment();
        }

        return payment;
    }

    public void saveOrder(Order order) {
        LOGGER.warn("TODO: Flesh out the saveOrder() method.");
    }

    public boolean checkDeliveryArea(String zipCode) {
        LOGGER.warn("TODO: Flesh out the checkDeliveryArea() method.");
        return "75075".equals(zipCode);
    }

    @Autowired
    CustomerService customerService;
}
