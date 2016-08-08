package part2.chapter25;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SampleFonts extends Applet {
    int next = 0;
    Font f;
    String msg;

    @Override
    public void init() {
        f = new Font("Dialog", Font.PLAIN, 12);
        msg = "Dialog";
        setFont(f);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                next++;
                switch (next) {
                    case 0:
                        f = new Font("Dialog", Font.PLAIN, 12);
                        msg = "Dialog";
                        break;
                    case 1:
                        f = new Font("DialogInput", Font.PLAIN, 12);
                        msg = "DialogInput";
                        break;
                    case 2:
                        f = new Font("SansSerif", Font.PLAIN, 12);
                        msg = "SansSerif";
                        break;
                    case 3:
                        f = new Font("Serif", Font.PLAIN, 12);
                        msg = "Serif";
                        break;
                    case 4:
                        f = new Font("Monospaced", Font.PLAIN, 12);
                        msg = "Monospaced";
                        next = -1;
                        break;
                }
                setFont(f);
                repaint();
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(msg, 4, 20);
    }
}
