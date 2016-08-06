package part1.chapter19;

import java.util.TimerTask;

class MyTimerTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("Timer task is executed");
    }
}
