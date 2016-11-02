package aspectjintegration;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AspectJExample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load(new String[]{"classpath:aspectjintegration.xml"});
        ctx.refresh();
        MessageWriter writer = new MessageWriter();
        writer.writeMessage();
        writer.foo();
    }
}
