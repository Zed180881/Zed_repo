package part2.chapter25;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class SampleFrame extends Frame {
    SampleFrame(String title) throws HeadlessException {
        super(title);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setVisible(false);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        g.drawString("This is in frame window", 10, 40);
    }
}
