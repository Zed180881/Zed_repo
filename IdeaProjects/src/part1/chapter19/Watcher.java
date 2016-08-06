package part1.chapter19;

import java.util.Observable;
import java.util.Observer;

class Watcher implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Method update() called, count is on " + ((Integer) arg).intValue());
    }
}
