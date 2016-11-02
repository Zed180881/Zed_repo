package main.java.injectref;

import org.springframework.context.support.GenericXmlApplicationContext;

public class InjectRef {
    private Oracle oracle;

    public void setOracle(Oracle oracle) {
        this.oracle = oracle;
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:spring-config-injectref.xml");
        context.refresh();
        InjectRef injectRef = (InjectRef) context.getBean("injectRef");
        System.out.println(injectRef);
    }

    @Override
    public String toString() {
        return oracle.defineMeaningOfLife();
    }
}
