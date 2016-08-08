package part2.chapter26;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SampleDialog extends Dialog implements ActionListener {

    SampleDialog(Frame owner, String title) {
        super(owner, title, false);
        setLayout(new FlowLayout());
        setSize(300, 200);

        add(new Label("Press this button:"));
        Button b = new Button("Cancel");
        add(b);
        b.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
    }

    @Override
    public void paint(Graphics g) {
        g.drawString("This is in the dialog box", 10, 70);
    }
}
