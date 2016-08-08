package part2.chapter25;

import java.applet.Applet;
import java.awt.*;

public class CenterText extends Applet {
    final Font f = new Font("SansSerif", Font.BOLD, 18);

    @Override
    public void paint(Graphics g) {
        Dimension d = this.getSize();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, d.width, d.height);
        g.setColor(Color.BLACK);
        g.setFont(f);
        drawCenteredString("This is centered.", d.width, d.height, g);
        g.drawRect(0, 0, d.width - 1, d.height - 1);
    }

    public void drawCenteredString(String s, int width, int height, Graphics g) {
        FontMetrics fm = g.getFontMetrics();
        int x = (width - fm.stringWidth(s)) / 2;
        int y = (fm.getAscent() + (height - (fm.getAscent() + fm.getDescent())) / 2);
        g.drawString(s, x, y);
    }
}
