package part3.chapter31;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MySwingApplet extends JApplet {
    JButton jButtonAlpha;
    JButton jButtonBeta;
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
            System.out.println("Cann't create because of " + e);
        }

    }

    private void makeGUI() {
        setLayout(new FlowLayout());
        jButtonAlpha = new JButton("Alpha");
        jButtonBeta = new JButton("Beta");
        jButtonAlpha.addActionListener(al -> jLabel.setText("Alpha was pressed."));
        jButtonBeta.addActionListener(al -> jLabel.setText("Beta was pressed."));
        add(jButtonAlpha);
        add(jButtonBeta);
        jLabel = new JLabel("Press a button.");
        add(jLabel);
    }
}
