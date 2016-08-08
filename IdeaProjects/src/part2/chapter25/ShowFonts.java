package part2.chapter25;

import java.applet.Applet;
import java.awt.*;

public class ShowFonts extends Applet {
    @Override
    public void paint(Graphics g) {
        int y = 16;
        String[] fontList;
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        fontList = ge.getAvailableFontFamilyNames();
        for (String s : fontList) {
            g.drawString(s, 4, y);
            y += 16;
        }
    }
}
