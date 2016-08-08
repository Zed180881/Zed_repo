package part2.chapter26;

import java.applet.Applet;
import java.awt.*;

public class LabelDemo extends Applet {
    @Override
    public void init() {
        Label one = new Label("one");
        Label two = new Label("two");
        Label three = new Label("three");
        add(one);
        add(two);
        add(three);
    }
}
