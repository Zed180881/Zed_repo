package part3.chapter32;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class JCheckBoxDemo extends JApplet implements ItemListener {
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
        JCheckBox checkBox = new JCheckBox("C");
        checkBox.addItemListener(this);
        add(checkBox);

        checkBox = new JCheckBox("C++");
        checkBox.addItemListener(this);
        add(checkBox);

        checkBox = new JCheckBox("Java");
        checkBox.addItemListener(this);
        add(checkBox);

        checkBox = new JCheckBox("Perl");
        checkBox.addItemListener(this);
        add(checkBox);

        jLabel = new JLabel("Select languages");
        add(jLabel);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        JCheckBox checkBox = (JCheckBox) e.getItem();
        if (checkBox.isSelected())
            jLabel.setText(checkBox.getText() + " is selected.");
        else
            jLabel.setText(checkBox.getText() + " is cleared");
    }
}
