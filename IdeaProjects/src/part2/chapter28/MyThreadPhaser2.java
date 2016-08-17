package part2.chapter28;

import java.util.concurrent.Phaser;

class MyThreadPhaser2 implements Runnable {
    Phaser phsr;
    String name;

    MyThreadPhaser2(Phaser phsr, String name) {
        this.phsr = phsr;
        this.name = name;
        phsr.register();
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (!phsr.isTerminated()) {
            System.out.println("Thread " + name + " begin phase " + phsr.getPhase());
            phsr.arriveAndAwaitAdvance();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
