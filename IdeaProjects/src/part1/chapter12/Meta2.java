package part1.chapter12;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@What(description = "Annotation of test class")
@MyAnno(str = "Meta2", val = 99)
class Meta2 {

    @What(description = "Annotation of test method")
    @MyAnno(str = "Testing", val = 100)
    public static void myMeth() {
        Meta2 ob = new Meta2();

        try {
            Annotation[] annos = ob.getClass().getAnnotations();
            System.out.println("All annotations of meta2 class");
            for (Annotation a : annos)
                System.out.println(a);
            System.out.println();

            Method m = ob.getClass().getMethod("myMeth");
            annos = m.getAnnotations();

            System.out.println("All annotations of myMeth method");
            for (Annotation a : annos)
                System.out.println(a);
        } catch (NoSuchMethodException e) {
            System.out.println("Method not found");
        }
    }

    public static void main(String[] args) {
        myMeth();
    }
}
