package taskschedulling;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ScheduleTaskSample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:tаsknamespace-app-context.xml");
        ctx.refresh();
        while (true) {
        }
    }
}
