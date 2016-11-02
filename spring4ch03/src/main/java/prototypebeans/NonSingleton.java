package main.java.prototypebeans;

import org.springframework.context.support.GenericXmlApplicationContext;

public class NonSingleton {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:spring-config-prototypebeans.xml");
        context.refresh();

        String s1 = (String) context.getBean("nonSingleton");
        String s2 = (String) context.getBean("nonSingleton");

        System.out.println("Identity Equal?: " + (s1 == s2));
        System.out.println("Value Equal?: " + (s1.equals(s2)));
        System.out.println(s1);
        System.out.println(s2);
    }
}
