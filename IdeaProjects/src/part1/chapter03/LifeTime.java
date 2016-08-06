package part1.chapter03;

/**
 * Created by Zed on 13.07.2016.
 */
class LifeTime {
    public static void main(String[] args) {
        int x;
        for (x = 0; x < 3; x++) {
            int y = -1;
            System.out.println("y равно: " + y);
            y = 100;
            System.out.println("y теперь равно: " + y);
        }
    }
}
