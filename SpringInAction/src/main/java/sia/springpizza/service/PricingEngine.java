package sia.springpizza.service;

import sia.springpizza.domain.Order;

public interface PricingEngine {
    public float calculateOrderTotal(Order order);
}
