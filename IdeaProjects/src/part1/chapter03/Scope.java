package part1.chapter03;

/**
 * Created by Zed on 13.07.2016.
 */
class Scope {
    public static void main(String[] args) {
        int x = 10;
        if (x == 10) {
            int y = 20;
            System.out.println("x и y: " + x + " " + y);
            x = y * 2;
        }
//        y = 100;

        System.out.println("x равно " + x);
    }
}
