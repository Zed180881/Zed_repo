package part2.chapter26;

import java.applet.Applet;
import java.awt.*;

public class DialogDemo extends Applet {
    Frame f;

    @Override
    public void init() {
        f = new MenuFrame("Dialog Demo");
        int width = Integer.parseInt(getParameter("width"));
        int height = Integer.parseInt(getParameter("height"));

        setSize(width, height);

        f.setSize(width, height);
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
}
