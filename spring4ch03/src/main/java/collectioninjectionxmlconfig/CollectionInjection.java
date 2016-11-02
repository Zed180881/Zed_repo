package main.java.collectioninjectionxmlconfig;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CollectionInjection {
    private Map<String, Object> map;
    private Properties properties;
    private Set set;
    private List list;

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:spring-config-collectioninjectionxmlconfig.xml");
        context.refresh();
        CollectionInjection instance = (CollectionInjection) context.getBean("injectCollection");
        instance.displayinfo();
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public void setList(List list) {
        this.list = list;
    }

    public void displayinfo() {
        System.out.println("Map contents:");
        map.entrySet().forEach(stringObjectEntry -> System.out.println("Key: " + stringObjectEntry.getKey() + " - Value: " + stringObjectEntry.getValue()));
        System.out.println("Properties contents: ");
        properties.entrySet().forEach(stringObjectEntry -> System.out.println("Key: " + stringObjectEntry.getKey() + " - Value: " + stringObjectEntry.getValue()));
        System.out.println("Set contents:");
        set.forEach(e -> System.out.println("Value: " + e));
        System.out.println("List contents:");
        list.forEach(e -> System.out.println("Value: " + e));
    }
}
