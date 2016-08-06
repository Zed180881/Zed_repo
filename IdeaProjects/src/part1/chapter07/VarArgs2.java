package part1.chapter07;

/**
 * Created by Zed on 19.07.2016.
 */
class VarArgs2 {
    static void vaTest(String msg, int... v) {
        System.out.print(msg + v.length + " Content: ");
        for (int x : v)
            System.out.print(x + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        vaTest("One parameter: ", 10);
        vaTest("Three parameters: ", 1, 2, 3);
        vaTest("Without parameters: ");

    }
}
