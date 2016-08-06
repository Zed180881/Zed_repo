package part1.chapter07;

/**
 * Created by Zed on 19.07.2016.1
 */
class Factorial {
    int fact(int n) {
        if (n == 1) return 1;
        int result = fact(n - 1) * n;
        return result;
    }
}
