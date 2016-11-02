package main.java.injectsimplexmlconfig;

import org.springframework.context.support.GenericXmlApplicationContext;

public class InjectSimple {
    private String name;
    private int age;
    private float height;
    private boolean programmer;
    private Long ageInSeconds;

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:spring-config-injectsimplexmlconfig.xml");
        context.refresh();
        InjectSimple injectSimple = (InjectSimple) context.getBean("injectSimple");
        System.out.println(injectSimple);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setProgrammer(boolean programmer) {
        this.programmer = programmer;
    }

    public void setAgeInSeconds(Long ageInSeconds) {
        this.ageInSeconds = ageInSeconds;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nAge: " + age + "\nHeight: " + height + "\nProgrammer: " + programmer + "\nAgeInSeconds: " + ageInSeconds;
    }
}
