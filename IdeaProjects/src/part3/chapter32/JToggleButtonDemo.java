package part3.chapter32;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.MalformedURLException;
import java.net.URL;

public class JToggleButtonDemo extends JApplet {
    JLabel jLabel;
    JToggleButton jToggleButton;

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
        jLabel = new JLabel("Button is off.");
        jToggleButton = new JToggleButton("On/off");
        jToggleButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (jToggleButton.isSelected())
                    jLabel.setText("Button is on.");
                else
                    jLabel.setText("Button is off.");
            }
        });
        add(jLabel);
        add(jToggleButton);
    }
}
