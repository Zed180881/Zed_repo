package part2.chapter26;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonDemo extends Applet implements ActionListener {
    String msg = "";
    Button yes, no, maybe;

    @Override
    public void init() {
        yes = new Button("Yes");
        no = new Button("No");
        maybe = new Button("Undecided");
        add(yes);
        add(no);
        add(maybe);

        yes.addActionListener(this);
        no.addActionListener(this);
        maybe.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        if (str.equals("Yes"))
            msg = "You pressed Yes.";
        else if (str.equals("No"))
            msg = "You pressed No.";
        else
            msg = "You pressed Undecided.";
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(msg, 6, 100);
    }
}
