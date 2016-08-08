package part2.chapter25;

import java.awt.*;
import java.awt.event.*;

class SampleFrameEvents extends Frame implements MouseListener, MouseMotionListener {
    String msg = "";
    int mouseX = 10, mouseY = 40;
    int movX = 10, movY = 40;

    public SampleFrameEvents(String title) throws HeadlessException {
        super(title);
        addMouseListener(this);
        addMouseMotionListener(this);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setVisible(false);
            }
        });
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
        mouseX = 10;
        mouseY = 54;
        msg = "Mouse just entered child";
        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        mouseX = 10;
        mouseY = 54;
        msg = "Mouse just exited child window";
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
        repaint(0, 0, 100, 60);
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(msg, mouseX, mouseY);
        g.drawString("Mouse at " + movX + ", " + movY, 10, 40);
    }
}
