package main.java.methodreplacement;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

public class MethodReplacementExample {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:spring-config-methodreplacement.xml");
        context.refresh();
        ReplacementTarget replacementTarget = (ReplacementTarget) context.getBean("replacementTarget");
        ReplacementTarget standardTarget = (ReplacementTarget) context.getBean("standardTarget");

        displayInfo(replacementTarget);
        displayInfo(standardTarget);
    }

    private static void displayInfo(ReplacementTarget replacementTarget) {

        System.out.println(replacementTarget.formatMessage("Hello World!"));
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("perfTest");
        for (int i = 0; i < 1000000; i++) {
            String out = replacementTarget.formatMessage("foo");
        }
        stopWatch.stop();
        System.out.println("1000000 invocations took " + stopWatch.getTotalTimeMillis() + " ms");
    }
}
