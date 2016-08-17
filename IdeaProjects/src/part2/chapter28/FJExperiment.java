package part2.chapter28;

import java.util.concurrent.ForkJoinPool;

public class FJExperiment {
    public static void main(String[] args) {
        int pLevel;
        int threshold;

        if (args.length != 2) {
            System.out.println("Use: FJExperiment parallelism threshold");
            return;
        }

        pLevel = Integer.parseInt(args[0]);
        threshold = Integer.parseInt(args[1]);

        long beginT, endT;

        ForkJoinPool fjp = new ForkJoinPool(pLevel);
        double[] nums = new double[1000000];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = (double) i;
        }

        Transform task = new Transform(nums, 0, nums.length, threshold);
        beginT = System.nanoTime();
        fjp.invoke(task);
        endT = System.nanoTime();

        System.out.println("Parallelism level: " + pLevel);
        System.out.println("Processing threshold: " + threshold);
        System.out.println("Processing time: " + (endT - beginT) + " ns");
    }
}
