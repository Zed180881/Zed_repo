package ch06_Factory.factory4;

import ch06_Factory.factory3.Message;

import javax.enterprise.util.AnnotationLiteral;


public class MessageLiteral extends AnnotationLiteral<Message> implements Message {
    private static final long serialVersionUID = 1L;
    private Type type;

    public MessageLiteral(Type type) {
        this.type = type;
    }

    public Type value() {
        return type;
    }
}