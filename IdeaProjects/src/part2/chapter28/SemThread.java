package part2.chapter28;

import java.util.concurrent.Semaphore;

class SemThread implements Runnable {
    String name;
    Semaphore sem;
    boolean increase;

    SemThread(String name, Semaphore sem, boolean increase) {
        this.name = name;
        this.sem = sem;
        this.increase = increase;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("Start thread " + name);
        try {
            System.out.println("Thread " + name + " waiting for permission");
            sem.acquire();
            System.out.println("Thread " + name + " acquired permission");
            for (int i = 0; i < 5; i++) {
                if (increase)
                    Shared.count++;
                else
                    Shared.count--;
                System.out.println(name + ": " + Shared.count);
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("Thread " + name + " released permission");
        sem.release();
    }
}
