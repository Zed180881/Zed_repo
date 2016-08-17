package part2.chapter28;

import java.util.concurrent.RecursiveTask;

class SumFork extends RecursiveTask<Double> {
    final int seqThreshold = 500;
    double[] data;
    int start, end;

    public SumFork(double[] data, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Double compute() {
        double sum = 0;

        if ((end - start) < seqThreshold) {
            for (int i = start; i < end; i++) {
                sum += data[i];
            }
        } else {
            int middle = (start + end) / 2;
            SumFork subTaskA = new SumFork(data, start, middle);
            SumFork subTaskB = new SumFork(data, middle, end);
            subTaskA.fork();
            subTaskB.fork();
            sum = subTaskA.join() + subTaskB.join();
        }
        return sum;
    }
}
