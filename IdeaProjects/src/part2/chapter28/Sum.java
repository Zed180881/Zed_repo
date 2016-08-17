package part2.chapter28;

import java.util.concurrent.Callable;

class Sum implements Callable<Integer> {
    int stop;

    Sum(int stop) {
        this.stop = stop;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= stop; i++) {
            sum += i;
        }
        return sum;
    }
}
