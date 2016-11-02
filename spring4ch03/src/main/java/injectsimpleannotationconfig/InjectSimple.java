package main.java.injectsimpleannotationconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service("injectSimple")
public class InjectSimple {
    @Value("Chris Schaefer")
    private String name;
    @Value("32")
    private int age;
    @Value("1.778")
    private float height;
    @Value("true")
    private boolean programmer;
    @Value("1009843200")
    private Long ageInSeconds;

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:spring-config-injectsimpleannotationconfig.xml");
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
