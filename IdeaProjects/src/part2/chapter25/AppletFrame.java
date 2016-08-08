package part2.chapter25;

import java.applet.Applet;
import java.awt.*;

public class AppletFrame extends Applet {
    Frame f;

    @Override
    public void init() {
        f = new SampleFrame("A frame window");
        f.setSize(250, 250);
        f.setVisible(true);
    }

    @Override
    public void start() {
        f.setVisible(true);
    }

    @Override
    public void stop() {
        f.setVisible(false);
    }

    @Override
    public void paint(Graphics g) {
        g.drawString("This is in applet window", 10, 20);
    }
}
