package part3.chapter32;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class JRadioButtonDemo extends JApplet implements ActionListener {
    JLabel jLabel;

    @Override
    public void init() {
        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                @Override
                public void run() {
                    makeGUI();
                }
            });
        } catch (Exception e) {
            System.out.println("Can not create because of " + e);
        }
    }

    private void makeGUI() {
        setLayout(new FlowLayout());
        JRadioButton b1 = new JRadioButton("A");
        b1.addActionListener(this);
        add(b1);

        JRadioButton b2 = new JRadioButton("B");
        b2.addActionListener(this);
        add(b2);

        JRadioButton b3 = new JRadioButton("C");
        b3.addActionListener(this);
        add(b3);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(b1);
        buttonGroup.add(b2);
        buttonGroup.add(b3);

        jLabel = new JLabel("Select one");
        add(jLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        jLabel.setText("You selected " + e.getActionCommand());
    }
}
