package factorybean;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.security.MessageDigest;

public class AccessingFactoryBeans {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring-config-messagedigestfactorybean.xml");
        ctx.refresh();
        MessageDigest digest = (MessageDigest) ctx.getBean("shaDigest");
        MessageDigestFactoryВean factoryВean = (MessageDigestFactoryВean) ctx.getBean("&shaDigest");
        try {
            MessageDigest shaDigest = factoryВean.getObject();
            System.out.println(shaDigest.digest("Hello world".getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
