package part2.chapter27;

import java.applet.Applet;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.StringTokenizer;

public class TrackedImageLoad extends Applet implements Runnable {
    MediaTracker tracker;
    int tracked;
    int frameRate = 5;
    int currentImg = 0;
    Thread motor;
    static final int MAXIMAGES = 10;
    Image[] img = new Image[MAXIMAGES];
    String[] name = new String[MAXIMAGES];
    volatile boolean stopFlag;

    @Override
    public void init() {
        tracker = new MediaTracker(this);
        StringTokenizer st = new StringTokenizer(getParameter("img"), "+");
        while (st.hasMoreTokens() && tracked <= MAXIMAGES) {
            name[tracked] = st.nextToken();
            try {
                img[tracked] = getImage(new URL(name[tracked]));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            tracker.addImage(img[tracked], tracked);
            tracked++;
        }
    }

    @Override
    public void paint(Graphics g) {
        String loaded = "";
        int donecount = 0;
        for (int i = 0; i < tracked; i++) {
            if (tracker.checkID(i, true)) {
                donecount++;
                loaded += name[i] + " ";
            }
        }
        Dimension d = getSize();
        int w = d.width;
        int h = d.height;

        if (donecount == tracked) {
            frameRate = 1;
            Image i = img[currentImg++];
            int iw = i.getWidth(null);
            int ih = i.getHeight(null);
            g.drawImage(i, (w - iw) / 2, (h - ih) / 2, null);
            if (currentImg >= tracked)
                currentImg = 0;
        } else {
            int x = w * donecount / tracked;
            g.setColor(Color.BLACK);
            g.fillRect(0, h / 3, x, 16);
            g.setColor(Color.WHITE);
            g.fillRect(x, h / 3, w - x, 16);
            g.setColor(Color.BLACK);
            g.drawString(loaded, 10, h / 2);
        }
    }

    @Override
    public void start() {
        motor = new Thread(this);
        stopFlag = false;
        motor.start();
    }

    @Override
    public void stop() {
        stopFlag = true;
    }

    @Override
    public void run() {
        motor.setPriority(Thread.MIN_PRIORITY);
        while (true) {
            repaint();
            try {
                Thread.sleep(1000 / frameRate);
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
                return;
            }
            if (stopFlag)
                return;
        }
    }
}
