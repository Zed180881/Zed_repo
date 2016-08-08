package part2.chapter25;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class WindowEvents extends Applet implements MouseListener, MouseMotionListener {
    SampleFrameEvents f;
    String msg = "";
    int mouseX = 0, mouseY = 10;
    int movX = 0, movY = 0;

    @Override
    public void init() {
        f = new SampleFrameEvents("Handle Mouse Events");
        f.setSize(300, 200);
        f.setVisible(true);
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    @Override
    public void stop() {
        f.setVisible(false);
    }

    @Override
    public void start() {
        f.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        msg = "Down";
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        msg = "Up";
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        mouseX = 0;
        mouseY = 24;
        msg = "Mouse just entered applet window";
        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        mouseX = 0;
        mouseY = 24;
        msg = "Mouse just exited applet window";
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        movX = e.getX();
        movY = e.getY();
        msg = "*";
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        movX = e.getX();
        movY = e.getY();
        repaint(0, 0, 100, 20);
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(msg, mouseX, mouseY);
        g.drawString("Mouse at " + movX + ", " + movY, 0, 10);
    }
}
