package proxyfactorybeanaop;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AopNamespaceExample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:proxyfactorybeanaop.xml");
        ctx.refresh();
        MyBean myBean = (MyBean) ctx.getBean("myBean");
        myBean.execute();
    }
}
