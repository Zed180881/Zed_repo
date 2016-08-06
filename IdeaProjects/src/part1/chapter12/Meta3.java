package part1.chapter12;

import java.lang.reflect.Method;

class Meta3 {

    @MyAnno()
    public static void myMeth() {
        Meta3 ob = new Meta3();

        try {
            Class<?> c = ob.getClass();
            Method m = c.getMethod("myMeth");
            MyAnno anno = m.getDeclaredAnnotation(MyAnno.class);
            System.out.println(anno.str() + " " + anno.val());
        } catch (NoSuchMethodException e) {
            System.out.println("Method not found");
        }
    }

    public static void main(String[] args) {
        myMeth();
    }
}
