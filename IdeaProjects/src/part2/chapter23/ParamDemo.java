package part2.chapter23;

import java.applet.Applet;
import java.awt.*;

public class ParamDemo extends Applet {
    String fontName;
    int fontSize;
    float leading;
    boolean active;

    @Override
    public void start() {
        fontName = getParameter("fontName") != null ? getParameter("fontName") : "Not Found";
        try {
            fontSize = getParameter("fontSize") != null ? Integer.parseInt(getParameter("fontSize")) : 0;
        } catch (NumberFormatException e) {
            fontSize = -1;
        }
        try {
            leading = getParameter("leading") != null ? Float.parseFloat(getParameter("leading")) : 0;
        } catch (NumberFormatException e) {
            fontSize = -1;
        }
        active = getParameter("accountEnabled") != null ? Boolean.parseBoolean(getParameter("accountEnabled")) : false;
    }

    @Override
    public void paint(Graphics g) {
        g.drawString("Font name: " + fontName, 0, 10);
        g.drawString("Font size: " + fontSize, 0, 26);
        g.drawString("Leading: " + leading, 0, 42);
        g.drawString("Account active: " + active, 0, 58);
    }
}
