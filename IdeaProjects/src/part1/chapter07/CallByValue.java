package part1.chapter07;

/**
 * Created by Zed on 19.07.2016.1
 */
class CallByValue {
    public static void main(String[] args) {
        Test1 ob = new Test1();
        int a = 15, b = 20;
        System.out.println("a & b before calling method: " + a + " " + b);
        ob.method(a, b);
        System.out.println("a & b after calling method: " + a + " " + b);

    }
}
