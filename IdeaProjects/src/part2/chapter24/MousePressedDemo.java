package part2.chapter24;

import java.applet.Applet;

public class MousePressedDemo extends Applet {
    @Override
    public void init() {
        addMouseListener(new MyMouseAdapter1(this));
    }
}
