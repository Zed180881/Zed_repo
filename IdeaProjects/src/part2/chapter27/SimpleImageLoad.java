package part2.chapter27;

import java.applet.Applet;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class SimpleImageLoad extends Applet {
    Image img;

    @Override
    public void init() {
        try {
            img = getImage(new URL("http://images.huffingtonpost.com/2015-09-14-1442247397-576929-lili1.jpg"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, this);
    }
}
