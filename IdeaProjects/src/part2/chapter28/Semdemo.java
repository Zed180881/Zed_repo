package part2.chapter28;

import java.util.concurrent.Semaphore;

class Semdemo {
    public static void main(String[] args) {
        Semaphore sem = new Semaphore(1);
        new SemThread("A", sem, true);
        new SemThread("B", sem, false);
    }
}
