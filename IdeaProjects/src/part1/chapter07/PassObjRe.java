package part1.chapter07;

/**
 * Created by Zed on 19.07.2016.1
 */
class PassObjRe {
    public static void main(String[] args) {
        Test3 ob = new Test3(15, 20);
        System.out.println("ob.a & ob.b before calling method: " + ob.a + " " + ob.b);
        ob.method(ob);
        System.out.println("ob.a & ob.b after calling method: " + ob.a + " " + ob.b);
    }
}
