package part2.chapter24;

import java.applet.Applet;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AnonimousInnerClassDemo extends Applet {
    @Override
    public void init() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                showStatus("Mouse Pressed");
            }
        });
    }
}
