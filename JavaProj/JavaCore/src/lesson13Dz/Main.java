package lesson13Dz;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {

    @SuppressWarnings("rawtypes")
    public static void main(String[] args) {
	Person person = new Person("Ivan", 20);
	Class aclass = person.getClass();
	Class bclass = Person.class;
	if (aclass.equals(bclass))
	    System.out.println("aclass equals bclass");
	System.out.println(aclass.getCanonicalName());
	System.out.println(aclass.getModifiers());
	System.out.println(aclass.getName());
	System.out.println(aclass.getSimpleName());
	System.out.println(aclass.getTypeName());
	System.out.println(aclass.hashCode());
	System.out.println(aclass.isAnnotation());
	System.out.println(aclass.isAnonymousClass());
	System.out.println(aclass.isArray());
	System.out.println(aclass.isEnum());
	System.out.println(aclass.isInstance(bclass));
	System.out.println(aclass.isInterface());
	System.out.println(aclass.isLocalClass());
	System.out.println(aclass.isMemberClass());
	System.out.println(aclass.isPrimitive());
	System.out.println(aclass.isSynthetic());
	System.out.println(aclass.toGenericString());
	System.out.println(aclass.toString());
	System.out.println(aclass.getSuperclass());
	
	int mods = aclass.getModifiers(); 
	if (Modifier.isPublic(mods)) { 
	    System.out.println("public"); 
	} 
	if (Modifier.isAbstract(mods)) { 
	    System.out.println("abstract"); 
	} 
	if (Modifier.isFinal(mods)) { 
	    System.out.println("final"); 
	}
	if (Modifier.isPrivate(mods)) { 
	    System.out.println("private"); 
	}
	
	Class[] interfaces = aclass.getInterfaces(); 
	for(Class cInterface : interfaces) { 
	    System.out.println( cInterface.getName() ); 
	}
	
	Field[] publicFields = aclass.getFields(); 
	for (Field field : publicFields) { 
	    Class fieldType = field.getType(); 
	    System.out.println("Имя: " + field.getName()); 
	    System.out.println("Тип: " + fieldType.getName()); 
	} 
	
	Field[] allFields = aclass.getDeclaredFields(); 
	for (Field field : allFields) { 
	    Class fieldType = field.getType(); 
	    System.out.println("Имя: " + field.getName()); 
	    System.out.println("Тип: " + fieldType.getName()); 
	}
	
	Constructor[] constructors = aclass.getDeclaredConstructors(); 
	for (Constructor constructor : constructors) { 
	    Class[] paramTypes = constructor.getParameterTypes(); 
	    for (Class paramType : paramTypes) { 
	        System.out.print(paramType.getName() + " "); 
	    } 
	    System.out.println(); 
	} 
	
	Method[] methods = aclass.getMethods(); 
	for (Method method : methods) { 
	    System.out.println("Имя: " + method.getName()); 
	    System.out.println("Возвращаемый тип: " + method.getReturnType().getName()); 
	 
	    Class[] paramTypes = method.getParameterTypes(); 
	    System.out.print("Типы параметров: "); 
	    for (Class paramType : paramTypes) { 
	        System.out.print(" " + paramType.getName()); 
	    } 
	    System.out.println(); 
	} 

    }

}
