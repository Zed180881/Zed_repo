package part2.chapter28;

import java.util.concurrent.Phaser;

class MyPhaser extends Phaser {
    int numPhases;

    MyPhaser(int parties, int numPhases) {
        super(parties);
        this.numPhases = numPhases - 1;
    }

    @Override
    protected boolean onAdvance(int phase, int registeredParties) {
        System.out.println("Phase " + phase + " ended");
        return (phase == numPhases || registeredParties == 0);
    }
}
