package part2.chapter24;

import java.applet.Applet;

public class AdapterDemo extends Applet {

    @Override
    public void init() {
        addMouseListener(new MyMouseAdapter(this));
        addMouseMotionListener(new MyMouseMotionAdapter(this));
    }
}
