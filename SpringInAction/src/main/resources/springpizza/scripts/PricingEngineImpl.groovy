import sia.springpizza.domain.Order;
import sia.springpizza.domain.Pizza;
import sia.springpizza.service.PricingEngine;
import java.io.Serializable;

class PricingEngineImpl implements PricingEngine, Serializable {
    public float calculateOrderTotal(Order order) {
        print "IN GROOVY";

        retun 99.99;
    }
}
