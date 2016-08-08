package part2.chapter27;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class DoubleBuffer extends Applet {
    int gap = 3;
    int mx, my;
    boolean flicker = true;
    Image buffer = null;
    int w, h;

    @Override
    public void init() {
        Dimension d = getSize();
        w = d.width;
        h = d.height;
        buffer = createImage(w, h);
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                mx = e.getX();
                my = e.getY();
                flicker = false;
                repaint();
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                mx = e.getX();
                my = e.getY();
                flicker = true;
                repaint();
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        Graphics screengc = null;
        if (!flicker) {
            screengc = g;
            g = buffer.getGraphics();
        }
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, w, h);
        g.setColor(Color.RED);
        for (int i = 0; i < w; i += gap) {
            g.drawLine(i, 0, w - i, h);
        }
        for (int i = 0; i < h; i += gap) {
            g.drawLine(0, i, w, h - i);
        }
        g.setColor(Color.BLACK);
        g.drawString("Press mouse button to double buffer", 10, h / 2);
        g.setColor(Color.YELLOW);
        g.fillOval(mx - gap, my - gap, gap * 2 + 1, gap * 2 + 1);
        if (!flicker) {
            screengc.drawImage(buffer, 0, 0, null);
        }
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }
}
