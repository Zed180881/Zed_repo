package part2.chapter28;

import java.util.concurrent.Phaser;

class PhaserDemo {
    public static void main(String[] args) {
        Phaser phsr = new Phaser(1);
        int curPhase;
        System.out.println("Threads launch");
        new MyThreadPhaser(phsr, "A");
        new MyThreadPhaser(phsr, "B");
        new MyThreadPhaser(phsr, "C");

        curPhase = phsr.getPhase();
        phsr.arriveAndAwaitAdvance();
        System.out.println("Phase " + curPhase + " ended");

        curPhase = phsr.getPhase();
        phsr.arriveAndAwaitAdvance();
        System.out.println("Phase " + curPhase + " ended");

        curPhase = phsr.getPhase();
        phsr.arriveAndAwaitAdvance();
        System.out.println("Phase " + curPhase + " ended");

        phsr.arriveAndDeregister();
        if (phsr.isTerminated())
            System.out.println("Phaser ended");

    }
}
