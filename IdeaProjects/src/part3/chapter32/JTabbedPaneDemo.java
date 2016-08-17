package part3.chapter32;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JTabbedPaneDemo extends JApplet {
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
        JTabbedPane jTabbedPane = new JTabbedPane();
        jTabbedPane.addTab("Cities", new CitiesPanel());
        jTabbedPane.addTab("Colors", new ColorsPanel());
        jTabbedPane.addTab("Flavors", new FlavorsPanel());
        add(jTabbedPane);
    }
}
