package proxyfactorybean;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ProxyFactoryBeanExample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:proxyfactorybean.xml");
        ctx.refresh();
        MyBean beanl = (MyBean) ctx.getBean("myBeanl");
        MyBean bean2 = (MyBean) ctx.getBean("myBean2");
        System.out.println("Bean 1");
        beanl.execute();
        System.out.println("\nBean 2");
        bean2.execute();
    }
}
