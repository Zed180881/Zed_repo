package part2.chapter23;

import java.applet.Applet;
import java.awt.*;
import java.net.URL;

public class Bases extends Applet {

    @Override
    public void paint(Graphics g) {
        String msg;
        URL url = getCodeBase();
        msg = "Code base: " + url.toString();
        g.drawString(msg, 10, 20);

        url = getDocumentBase();
        msg = "Document base: " + url.toString();
        g.drawString(msg, 10, 40);
    }
}
