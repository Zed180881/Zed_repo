package part2.chapter23;

import java.applet.Applet;
import java.applet.AppletContext;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class ACDemo extends Applet {

    @Override
    public void start() {
        AppletContext ac = getAppletContext();
        try {
            URL url = new URL("http://tapochek.net/index.php");
            ac.showDocument(url);
        } catch (MalformedURLException e) {
            showStatus("URL not found");
        }
    }
}
