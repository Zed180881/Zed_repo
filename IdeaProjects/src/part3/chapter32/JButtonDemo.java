package part3.chapter32;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

public class JButtonDemo extends JApplet implements ActionListener {
    JLabel jLabel;

    @Override
    public void init() {
        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                @Override
                public void run() {
                    try {
                        makeGUI();
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (Exception e) {
            System.out.println("Can not create because of " + e);
        }
    }

    private void makeGUI() throws MalformedURLException {
        setLayout(new FlowLayout());
        ImageIcon hourglass = new ImageIcon(new URL("http://cdn.mysitemyway.com/etc-mysitemyway/icons/legacy-previews/icons/blue-jelly-icons-business/078557-blue-jelly-icon-business-hourglass.png"));
        JButton jButton = new JButton(hourglass);
        jButton.setActionCommand("Hourglass");
        jButton.addActionListener(this);
        add(jButton);

        ImageIcon analog = new ImageIcon(new URL("http://a5.mzstatic.com/us/r30/Purple/v4/b1/97/e4/b197e428-09d8-3834-452e-1fdfaf6d7060/screen480x480.jpeg"));
        jButton = new JButton(analog);
        jButton.setActionCommand("Analog Clock");
        jButton.addActionListener(this);
        add(jButton);

        ImageIcon digital = new ImageIcon(new URL("https://lh6.googleusercontent.com/GZT5z8QK25gbkDqaJvOOaQ7p4yAsLDmKM36o9Az3zB0SRGPsyDr0ouTVCZUKWYQ7v2bNxcgT=s640-h400-e365"));
        jButton = new JButton(digital);
        jButton.setActionCommand("Digital Clock");
        jButton.addActionListener(this);
        add(jButton);

        ImageIcon stopwatch = new ImageIcon(new URL("http://pngimg.com/upload/clock_PNG6614.png"));
        jButton = new JButton(stopwatch);
        jButton.setActionCommand("Stopwatch");
        jButton.addActionListener(this);
        add(jButton);

        jLabel = new JLabel("Choose a Timepiece");
        add(jLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        jLabel.setText("You selected " + e.getActionCommand());
    }
}
