package part2.chapter28;

import java.util.concurrent.CountDownLatch;

class CDLDemo {
    public static void main(String[] args) {
        CountDownLatch cdl = new CountDownLatch(5);
        System.out.println("Start execution thread");
        new MyThreadCDL(cdl);
        try {
            cdl.await();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("Finish execution thread");
    }
}
