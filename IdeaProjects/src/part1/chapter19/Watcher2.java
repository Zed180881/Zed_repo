package part1.chapter19;

import java.util.Observable;
import java.util.Observer;

class Watcher2 implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        if (((Integer) arg).intValue() == 0)
            System.out.println("Ready" + '\7');
    }
}
