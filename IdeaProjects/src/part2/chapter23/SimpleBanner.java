package part2.chapter23;

import java.applet.Applet;
import java.awt.*;

public class SimpleBanner extends Applet implements Runnable {
    String msg = " A Simple Moving Banner.";
    Thread t = null;
    int state;
    volatile boolean stopFlag;

    @Override
    public void init() {
        setBackground(Color.CYAN);
        setForeground(Color.RED);
    }

    @Override
    public void start() {
        t = new Thread(this);
        stopFlag = false;
        t.start();
    }

    @Override
    public void stop() {
        stopFlag = true;
        t = null;
    }

    @Override
    public void paint(Graphics g) {
        char ch = msg.charAt(0);
        msg = msg.substring(1, msg.length());
        msg += ch;
        g.drawString(msg, 50, 30);
    }

    @Override
    public void run() {
        while (true) {
            try {
                repaint();
                Thread.sleep(100);
                if (stopFlag)
                    break;
            } catch (InterruptedException e) {
            }
        }
    }
}
