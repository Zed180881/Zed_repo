package part2.chapter28;

import java.util.concurrent.CountDownLatch;

class MyThreadCDL implements Runnable {
    CountDownLatch latch;

    public MyThreadCDL(CountDownLatch latch) {
        this.latch = latch;
        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            latch.countDown();
        }
    }
}
