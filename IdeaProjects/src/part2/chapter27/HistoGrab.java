package part2.chapter27;

import java.applet.Applet;
import java.awt.*;
import java.awt.image.PixelGrabber;
import java.net.URL;

public class HistoGrab extends Applet {
    Dimension d;
    Image img;
    int iw, ih;
    int[] pixels;
    int w, h;
    int[] hist = new int[256];
    int maxHist = 0;

    @Override
    public void init() {
        d = getSize();
        w = d.width;
        h = d.height;
        try {
            img = getImage(new URL("http://images.huffingtonpost.com/2015-09-14-1442247397-576929-lili1.jpg"));
            MediaTracker t = new MediaTracker(this);
            t.addImage(img, 0);
            t.waitForID(0);
            iw = img.getWidth(null);
            ih = img.getHeight(null);
            pixels = new int[iw * ih];
            PixelGrabber pg = new PixelGrabber(img, 0, 0, iw, ih, pixels, 0, iw);
            pg.grabPixels();
        } catch (Exception e) {
            System.out.println("Exception: " + e);
            return;
        }
        for (int i = 0; i < iw * ih; i++) {
            int p = pixels[i];
            int r = 0xff & (p >> 16);
            int g = 0xff & (p >> 8);
            int b = 0xff & (p);
            int y = (int) (.33 * r + .56 * g + .11 * b);
            hist[y]++;
        }
        for (int i = 0; i < 256; i++) {
            if (hist[i] > maxHist)
                maxHist = hist[i];
        }
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, null);
        int x = (w - 256) / 2;
        int lastY = h - h * hist[0] / maxHist;
        for (int i = 0; i < 256; i++, x++) {
            int y = h - h * hist[i] / maxHist;
            g.setColor(new Color(i, i, i));
            g.fillRect(x, y, 1, h);
            g.setColor(Color.RED);
            g.drawLine(x - 1, lastY, x, y);
            lastY = y;
        }
    }
}
