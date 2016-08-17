package part2.chapter28;

import java.util.concurrent.Semaphore;

class Q {
    int n;

    static Semaphore semCon = new Semaphore(0);
    static Semaphore semProd = new Semaphore(1);

    void get() {
        try {
            semCon.acquire();
        } catch (InterruptedException e) {
            System.out.println("Interrupted Exception caught");
        }
        System.out.println("Get: " + n);
        semProd.release();
    }

    void put(int n) {
        try {
            semProd.acquire();
        } catch (InterruptedException e) {
            System.out.println("Interrupted Exception caught");
        }
        this.n = n;
        System.out.println("Send: " + n);
        semCon.release();
    }
}
