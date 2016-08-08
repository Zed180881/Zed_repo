package part2.chapter25;

import java.applet.Applet;
import java.awt.*;

public class FontInfo extends Applet {
    @Override
    public void paint(Graphics g) {
        Font f = g.getFont();
        String fontName = f.getName();
        String fontFamily = f.getFamily();
        int fontSize = f.getSize();
        int fontStyle = f.getStyle();
        String msg = "Font: " + fontName + ", Family: " + fontFamily + ", Size: " + fontSize + ", Style: ";
        if ((fontStyle & Font.BOLD) == Font.BOLD)
            msg += "Bold ";
        if ((fontStyle & Font.ITALIC) == Font.ITALIC)
            msg += "Italic ";
        if ((fontStyle & Font.PLAIN) == Font.PLAIN)
            msg += "Plain";
        g.drawString(msg, 4, 16);
    }
}
