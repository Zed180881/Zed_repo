package part3.chapter32;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

public class JComboBoxDemo extends JApplet {
    JLabel jLabel;
    JComboBox<String> jComboBox;
    String[] timepieces = {"Hourglass", "Analog", "Digital", "Stopwatch"};

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
        jComboBox = new JComboBox<>(timepieces);
        add(jComboBox);
        jComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = (String) jComboBox.getSelectedItem();
                switch (s) {
                    case "Hourglass":
                        try {
                            jLabel.setIcon(new ImageIcon(new URL("http://cdn.mysitemyway.com/etc-mysitemyway/icons/legacy-previews/icons/blue-jelly-icons-business/078557-blue-jelly-icon-business-hourglass.png")));
                        } catch (MalformedURLException e1) {
                            e1.printStackTrace();
                        }
                        break;
                    case "Analog":
                        try {
                            jLabel.setIcon(new ImageIcon(new URL("http://a5.mzstatic.com/us/r30/Purple/v4/b1/97/e4/b197e428-09d8-3834-452e-1fdfaf6d7060/screen480x480.jpeg")));
                        } catch (MalformedURLException e1) {
                            e1.printStackTrace();
                        }
                        break;
                    case "Digital":
                        try {
                            jLabel.setIcon(new ImageIcon(new URL("https://lh6.googleusercontent.com/GZT5z8QK25gbkDqaJvOOaQ7p4yAsLDmKM36o9Az3zB0SRGPsyDr0ouTVCZUKWYQ7v2bNxcgT=s640-h400-e365")));
                        } catch (MalformedURLException e1) {
                            e1.printStackTrace();
                        }
                        break;
                    case "Stopwatch":
                        try {
                            jLabel.setIcon(new ImageIcon(new URL("http://pngimg.com/upload/clock_PNG6614.png")));
                        } catch (MalformedURLException e1) {
                            e1.printStackTrace();
                        }
                        break;
                }
            }
        });

        try {
            jLabel = new JLabel(new ImageIcon(new URL("http://cdn.mysitemyway.com/etc-mysitemyway/icons/legacy-previews/icons/blue-jelly-icons-business/078557-blue-jelly-icon-business-hourglass.png")));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        add(jLabel);
    }
}
