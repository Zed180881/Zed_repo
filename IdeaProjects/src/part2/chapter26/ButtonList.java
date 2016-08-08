package part2.chapter26;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonList extends Applet implements ActionListener {
    String msg = "";
    Button[] bList = new Button[3];

    @Override
    public void init() {
        Button yes = new Button("Yes");
        Button no = new Button("No");
        Button maybe = new Button("Undecided");
        bList[0] = (Button) add(yes);
        bList[1] = (Button) add(no);
        bList[2] = (Button) add(maybe);

        for (Button button : bList) {
            button.addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (Button button : bList) {
            if (e.getSource() == button)
                msg = "You pressed " + button.getLabel();
        }
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(msg, 6, 100);
    }
}
