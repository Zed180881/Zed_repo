package part2.chapter28;

import java.util.concurrent.locks.ReentrantLock;

class LockDemo {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        new LockThread(lock, "A");
        new LockThread(lock, "B");
    }
}
