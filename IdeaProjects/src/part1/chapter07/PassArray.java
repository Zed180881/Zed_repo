package part1.chapter07;

/**
 * Created by Zed on 19.07.2016.
 */
class PassArray {
    static void vaTest(int[] v) {
        System.out.print("Number of arguments: " + v.length + " Content: ");
        for (int x : v)
            System.out.print(x + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] n1 = {10};
        int[] n2 = {1, 2, 3};
        int[] n3 = {};

        vaTest(n1);
        vaTest(n2);
        vaTest(n3);

    }
}
