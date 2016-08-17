package part3.chapter32;

import javax.swing.*;
import java.awt.*;

public class JScrollPaneDemo extends JApplet {
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
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(20, 20));
        int b = 0;
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                jPanel.add(new JButton("Button " + b));
                ++b;
            }
        }
        JScrollPane jScrollPane = new JScrollPane(jPanel);
        add(jScrollPane, BorderLayout.CENTER);
    }
}
