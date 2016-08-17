package part2.chapter28;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

class MyThreadCB implements Runnable {
    CyclicBarrier cBar;
    String name;

    public MyThreadCB(CyclicBarrier cBar, String name) {
        this.cBar = cBar;
        this.name = name;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println(name);
        try {
            cBar.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
