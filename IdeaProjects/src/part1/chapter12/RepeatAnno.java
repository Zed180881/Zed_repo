package part1.chapter12;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

class RepeatAnno {

    @MyAnno1(str = "First Annotation", val = -1)
    @MyAnno1(str = "Second Annotation", val = 100)
    public static void myMeth(String str, int i) {
        RepeatAnno ob = new RepeatAnno();

        try {
            Class<?> c = ob.getClass();
            Method m = c.getMethod("myMeth", String.class, int.class);
            Annotation anno = m.getAnnotation(MyRepeatedAnnos.class);
            System.out.println(anno);
        } catch (NoSuchMethodException e) {
            System.out.println("Method not found");
        }
    }

    public static void main(String[] args) {
        myMeth("Test", 10);
    }

}
