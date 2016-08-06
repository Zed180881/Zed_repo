package part1.chapter19;

import java.util.Observable;

class BeingWatched extends Observable {
    void counter(int period) {
        for (; period >= 0; period--) {
            setChanged();
            notifyObservers(new Integer(period));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Sleep Interrupted");
            }
        }
    }
}
