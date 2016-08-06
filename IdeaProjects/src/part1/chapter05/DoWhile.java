package part1.chapter05;

/**
 * Created by Zed on 14.07.2016.
 */
class DoWhile {
    public static void main(String[] args) {
        int n = 10;
        do {
            System.out.println("такт " + n);
        } while (--n > 0);
    }
}
