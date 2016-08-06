package part1.chapter07;

/**
 * Created by Zed on 19.07.2016.
 */
class VarArgs4 {
    static void vaTest(int... v) {
        System.out.print("vaTest(int ..." + "Arguments number " + v.length + " Content: ");
        for (int x : v)
            System.out.print(x + " ");
        System.out.println();
    }

    static void vaTest(boolean... v) {
        System.out.print("vaTest(boolean ..." + "Arguments number " + v.length + " Content: ");
        for (boolean x : v)
            System.out.print(x + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        vaTest(1, 2, 3);
        vaTest(true, false, true);
//        vaTest(); error
    }
}
