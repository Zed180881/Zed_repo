package part2.chapter28;

import java.util.concurrent.CyclicBarrier;

class BarDemo {
    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(3, new BarAction());
        System.out.println("Start threads");
        new MyThreadCB(cb, "A");
        new MyThreadCB(cb, "B");
        new MyThreadCB(cb, "C");
        new MyThreadCB(cb, "X");
        new MyThreadCB(cb, "Y");
        new MyThreadCB(cb, "Z");
    }
}
