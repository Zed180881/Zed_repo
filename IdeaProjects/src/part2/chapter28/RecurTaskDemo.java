package part2.chapter28;

import java.util.concurrent.ForkJoinPool;

class RecurTaskDemo {
    public static void main(String[] args) {
        ForkJoinPool fjp = new ForkJoinPool();
        double[] nums = new double[5000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (double) (((i % 2) == 0) ? i : -i);
        }

        SumFork task = new SumFork(nums, 0, nums.length);
        double summation = fjp.invoke(task);
        System.out.println("Sum: " + summation);
    }
}
