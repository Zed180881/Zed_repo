package part1.chapter07;

/**
 * Created by Zed on 19.07.2016.1
 */
class Overload {
    public static void main(String[] args) {
        OverloadDemo ob = new OverloadDemo();
//        double result;
        int i = 88;
        ob.test();
//        ob.test(10);
        ob.test(10, 20);
//        result = ob.test(123.25);
//        System.out.println("Result of calling ob.test(123.25): " + result);
        ob.test(i);
        ob.test(123.2);
    }
}
