package part1.chapter13;

import java.applet.Applet;
import java.awt.*;

public class SimpleApplet extends Applet {
    @Override
    public void paint(Graphics g) {
        g.drawString("Simple applet", 20, 20);
    }
}
