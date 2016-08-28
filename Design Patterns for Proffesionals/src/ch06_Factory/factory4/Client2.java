package ch06_Factory.factory4;

import ch06_Factory.factory3.Message;
import ch06_Factory.factory3.MessageType;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@TransactionAttribute(TransactionAttributeType.REQUIRED)
@ApplicationScoped
public class Client2 {
    @Inject
    MessageFactory mf;

    public void doMessage() {
        MessageType m = mf.getMessage(Message.Type.SHORT);
        m.setMessage("This is a short message");
        System.out.println(m.getMessage());
        m = mf.getMessage(Message.Type.LONG);
        m.setMessage("This is a long message");
        System.out.println(m.getMessage());
    }
}