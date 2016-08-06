package part1.chapter05;

/**
 * Created by Zed on 14.07.2016.
 */
class BreakLoop {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            if (i == 10)
                break;
            System.out.println("i: " + i);
        }
        System.out.println("Цикл завершен.");
    }
}
