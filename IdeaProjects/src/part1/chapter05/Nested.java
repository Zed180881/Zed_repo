package part1.chapter05;

/**
 * Created by Zed on 14.07.2016.
 */
class Nested {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            for (int j = i; j < 10; j++) {
                System.out.print(".");
            }
            System.out.println();
        }
    }
}
