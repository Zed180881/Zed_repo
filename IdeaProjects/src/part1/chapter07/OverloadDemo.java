package part1.chapter07;

/**
 * Created by Zed on 19.07.2016.1
 */
class OverloadDemo {
    void test() {
        System.out.println("No parameters");
    }

   /* void test(int a) {
        System.out.println("a: " + a);
    }*/

    void test(int a, int b) {
        System.out.println("a & b: " + a + " " + b);
    }

    void test(double a) {
        System.out.println("test(double a): " + a);
    }

//    double test(double a) {
//        System.out.println("double a: " + a);
//        return a * a;
//    }
}

