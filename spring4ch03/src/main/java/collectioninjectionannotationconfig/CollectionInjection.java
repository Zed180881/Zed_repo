package main.java.collectioninjectionannotationconfig;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

@Service("injectCollection")
public class CollectionInjection {
    @Resource(name = "map")
    private Map<String, Object> map;
    @Resource(name = "properties")
    private Properties properties;
    @Resource(name = "set")
    private Set set;
    @Resource(name = "list")
    private List list;

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:spring-config-collectioninjectionannotationconfig.xml");
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
