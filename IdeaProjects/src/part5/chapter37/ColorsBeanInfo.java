package part5.chapter37;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;

public class ColorsBeanInfo extends SimpleBeanInfo {
    @Override
    public PropertyDescriptor[] getPropertyDescriptors() {
        try {
            PropertyDescriptor rectangular = new PropertyDescriptor("rectangular", Colors.class);
            PropertyDescriptor[] pd = {rectangular};
            return pd;
        } catch (IntrospectionException e) {
            System.out.println("Exception caught: " + e);
        }
        return null;
    }
}
