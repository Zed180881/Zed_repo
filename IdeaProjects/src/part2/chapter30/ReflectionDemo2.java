package part2.chapter30;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionDemo2 {
    public static void main(String[] args) {
        try {
            A a = new A();
            Class<?> c = a.getClass();
            System.out.println("Open methods: ");
            Method[] methods = c.getDeclaredMethods();
            for (Method method : methods) {
                int modifiers = method.getModifiers();
                if (Modifier.isPublic(modifiers))
                    System.out.println(" " + method.getName());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
