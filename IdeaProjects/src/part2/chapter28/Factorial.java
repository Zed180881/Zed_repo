package part2.chapter28;

import java.util.concurrent.Callable;

class Factorial implements Callable<Integer> {
    int stop;

    Factorial(int stop) {
        this.stop = stop;
    }

    @Override
    public Integer call() throws Exception {
        int fact = 1;
        for (int i = 2; i <= stop; i++) {
            fact *= i;
        }
        return fact;
    }
}
