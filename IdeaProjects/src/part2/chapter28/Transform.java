package part2.chapter28;

import java.util.concurrent.RecursiveAction;

class Transform extends RecursiveAction {
    int seqThreshold;
    double[] data;
    int start, end;

    public Transform(double[] data, int start, int end, int seqThreshold) {
        this.data = data;
        this.start = start;
        this.end = end;
        this.seqThreshold = seqThreshold;
    }

    @Override
    protected void compute() {

        if ((end - start) < seqThreshold) {
            for (int i = start; i < end; i++) {
                if ((data[i] % 2) == 0)
                    data[i] = Math.sqrt(data[i]);
                else
                    data[i] = Math.cbrt(data[i]);
            }
        } else {
            int middle = (start + end) / 2;
            invokeAll(new Transform(data, start, middle, seqThreshold), new Transform(data, middle, end, seqThreshold));
        }
    }
}
