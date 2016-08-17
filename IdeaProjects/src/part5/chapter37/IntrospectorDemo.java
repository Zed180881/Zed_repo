package part5.chapter37;

import java.beans.BeanInfo;
import java.beans.EventSetDescriptor;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

public class IntrospectorDemo {
    public static void main(String[] args) {
        try {
            Colors colors = new Colors();
            Class<?> c = colors.getClass();
            BeanInfo beanInfo = Introspector.getBeanInfo(c);
            System.out.println("Properties:");
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor descriptor : propertyDescriptors) {
                System.out.println("\t" + descriptor.getName());
            }
            System.out.println("Events:");
            EventSetDescriptor[] eventSetDescriptors = beanInfo.getEventSetDescriptors();
            for (EventSetDescriptor setDescriptor : eventSetDescriptors) {
                System.out.println("\t" + setDescriptor.getName());
            }
        } catch (Exception e) {
            System.out.println("Exception caught: " + e);
        }
    }
}
