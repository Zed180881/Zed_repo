package part2.chapter28;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

class LockThread implements Runnable {
    String name;
    ReentrantLock lock;

    LockThread(ReentrantLock lock, String name) {
        this.name = name;
        this.lock = lock;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("Start thread " + name);
        try {
            System.out.println("Thread " + name + " waiting for locking lock");
            lock.lock();
            System.out.println("Thread " + name + " locked lock");
            Shared.count++;
            System.out.println("Thread" + name + ": " + Shared.count);
            System.out.println("Thread " + name + " is waiting");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        } finally {
            System.out.println("Thread " + name + " is unlocking lock");
            lock.unlock();
        }
    }
}
