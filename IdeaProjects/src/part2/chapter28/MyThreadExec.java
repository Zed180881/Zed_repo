package part2.chapter28;

import java.util.concurrent.CountDownLatch;

class MyThreadExec implements Runnable {
    String name;
    CountDownLatch latch;

    MyThreadExec(CountDownLatch latch, String name) {
        this.latch = latch;
        this.name = name;
        new Thread(this);
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + ": " + i);
            latch.countDown();
        }
    }
}
