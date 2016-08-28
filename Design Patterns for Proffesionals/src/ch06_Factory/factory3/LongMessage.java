package ch06_Factory.factory3;

import javax.enterprise.context.Dependent;

@Message(Message.Type.LONG)
@Dependent
public class LongMessage implements MessageType {
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }
}