package main.java.helloworldspringannotationconfig;

import org.springframework.context.support.GenericXmlApplicationContext;

public class DeclareSpringComponents {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:spring-config-helloworldannotationconfig.xml");
        context.refresh();
        MessageProvider messageProvider = context.getBean("messageProvider", MessageProvider.class);
        System.out.println(messageProvider.getMessage());

        MessageRenderer messageRenderer = context.getBean("messageRenderer", MessageRenderer.class);
        messageRenderer.render();
    }
}
