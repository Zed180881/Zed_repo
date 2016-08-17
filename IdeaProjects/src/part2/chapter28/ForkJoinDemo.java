package part2.chapter28;

import java.util.concurrent.ForkJoinPool;

class ForkJoinDemo {
    public static void main(String[] args) {
        ForkJoinPool fjp = new ForkJoinPool();
        double[] nums = new double[100000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (double) i;
        }

        System.out.println("Part of source sequence:");
        for (int i = 0; i < 10; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();

        SqrtTransform task = new SqrtTransform(nums, 0, nums.length);
        fjp.invoke(task);

        System.out.println("Part of proceeded sequence:");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%.4f ", nums[i]);
        }
        System.out.println();
    }
}
