package factorymethod;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MessageDigestFactoryExample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring-config-messagedigestfactorymethod.xml");
        ctx.refresh();
        MessageDigester digester = (MessageDigester) ctx.getBean("digester");
        digester.digest("Hello World!");
    }
}
