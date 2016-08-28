package ch06_Factory.factory2;

import ch06_Factory.observer.MyEvent;

import javax.enterprise.inject.Produces;


// LISTING 6‐21
public class EventProducer2 {
    @Produces
    @MyEvent(MyEvent.Type.LOGGING)
    public String messageAFactory() {
        return "A message";
    }

    @Produces
    @MyEvent(MyEvent.Type.MESSAGE)
    public String messageBFactory() {
        return "Another message";
    }
}
