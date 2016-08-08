package part2.chapter24;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SimpleKey extends Applet implements KeyListener {
    String msg = "";
    int x = 10, y = 20;

    @Override
    public void init() {
        addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        msg += e.getKeyChar();
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        showStatus("Key Down " + e.getKeyChar());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        showStatus("Key Released " + e.getKeyChar());
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(msg, x, y);
    }
}
