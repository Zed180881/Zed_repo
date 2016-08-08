package part2.chapter26;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ListDemo extends Applet implements ActionListener {
    String msg = "";
    List os, browser;

    @Override
    public void init() {
        os = new List(4, true);
        browser = new List(4, false);
        os.add("Windows");
        os.add("Android");
        os.add("Solaris");
        os.add("Mac OS");

        browser.add("Internet Explorer");
        browser.add("Firefox");
        browser.add("Chrome");
        browser.select(1);

        add(os);
        add(browser);

        os.addActionListener(this);
        browser.addActionListener(this);
    }

    @Override
    public void paint(Graphics g) {
        int[] idx;
        msg = "Current OS: ";
        idx = os.getSelectedIndexes();
        for (int i : idx) {
            msg += os.getItem(i) + " ";
        }
        g.drawString(msg, 6, 120);
        msg = "Current browser: ";
        msg += browser.getSelectedItem();
        g.drawString(msg, 6, 140);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
