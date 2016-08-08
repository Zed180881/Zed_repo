package part2.chapter23;

import java.applet.Applet;
import java.awt.*;

public class StatusWindow extends Applet {
    @Override
    public void init() {
        setBackground(Color.CYAN);
    }

    @Override
    public void paint(Graphics g) {
        g.drawString("This is the applet window.", 10, 20);
        showStatus("This is shown in the status window.");
    }
}
