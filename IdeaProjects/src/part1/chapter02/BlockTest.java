package part1.chapter02;

/**
 * Created by Zed on 13.07.2016.1
 */
class BlockTest {

    public static void main(String[] args) {

        int y = 20;

        for (int x = 0; x < 10; x++) {
            System.out.println("Значение x: " + x);
            System.out.println("Значение y: " + y);
            y = y - 2;
        }
    }

}
