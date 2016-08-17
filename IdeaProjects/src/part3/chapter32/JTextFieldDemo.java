package part3.chapter32;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class JTextFieldDemo extends JApplet {
    JTextField jTextField;

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
        jTextField = new JTextField(15);
        add(jTextField);
        jTextField.addActionListener(e -> showStatus(jTextField.getText()));
    }
}
