package part1.chapter05;

/**
 * Created by Zed on 14.07.2016.
 */
class Continue {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
            if (i % 2 == 0)
                continue;
            System.out.println();
        }
    }
}
