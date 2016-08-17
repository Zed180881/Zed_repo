package part3.chapter32;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

public class JLabelDemo extends JApplet {
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
        try {

            ImageIcon imageIcon = new ImageIcon(new URL("http://cdn.mysitemyway.com/etc-mysitemyway/icons/legacy-previews/icons/blue-jelly-icons-business/078557-blue-jelly-icon-business-hourglass.png"));
            JLabel jLabel = new JLabel("Hourglass", imageIcon, JLabel.CENTER);
            add(jLabel);
        } catch (MalformedURLException e) {
            System.out.println("URL error " + e);
        }
    }
}
