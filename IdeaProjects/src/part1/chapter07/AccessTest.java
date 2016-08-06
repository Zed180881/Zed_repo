package part1.chapter07;

/**
 * Created by Zed on 19.07.2016.
 */
class AccessTest {
    public static void main(String[] args) {
        Test5 ob = new Test5();
        ob.a = 10;
        ob.b = 20;
//        ob.c = 100; access error

        ob.setc(100);

        System.out.println("a, b, c: " + ob.a + " " + ob.b + " " + ob.getc());

    }
}
