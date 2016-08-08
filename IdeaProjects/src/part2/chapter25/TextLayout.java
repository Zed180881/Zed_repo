package part2.chapter25;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.StringTokenizer;

public class TextLayout extends Applet {
    final int LEFT = 0;
    final int RIGHT = 1;
    final int CENTER = 2;
    final int LEFTRIGHT = 3;
    int align;
    Dimension d;
    Font f;
    FontMetrics fm;
    int fontSize;
    int fh, bl;
    int space;
    String text;

    @Override
    public void init() {
        setBackground(Color.WHITE);
        text = getParameter("text");
        try {
            fontSize = Integer.parseInt(getParameter("fontSize"));
        } catch (NumberFormatException e) {
            fontSize = 14;
        }
        align = LEFT;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                align = (align + 1) % 4;
                repaint();
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        update(g);
    }

    @Override
    public void update(Graphics g) {
        d = getSize();
        g.setColor(getBackground());
        g.fillRect(0, 0, d.width, d.height);
        if (f == null)
            f = new Font(getParameter("fontName"), Font.PLAIN, fontSize);
        g.setFont(f);
        if (fm == null) {
            fm = g.getFontMetrics();
            bl = fm.getAscent();
            fh = bl + fm.getDescent();
            space = fm.stringWidth(" ");
        }
        g.setColor(Color.BLACK);
        StringTokenizer st = new StringTokenizer(text);
        int x = 0;
        int nextX;
        int y = 0;
        String word, sp;
        int wordCount = 0;
        String line = "";
        while (st.hasMoreTokens()) {
            word = st.nextToken();
            if (word.equals("<P>")) {
                drawString(g, line, wordCount, fm.stringWidth(line), y + bl);
                line = "";
                wordCount = 0;
                x = 0;
                y = y + (fh * 2);
            } else {
                int w = fm.stringWidth(word);
                if ((nextX = (x + space + w)) > d.width) {
                    drawString(g, line, wordCount, fm.stringWidth(line), y + bl);
                    line = "";
                    wordCount = 0;
                    x = 0;
                    y = y + fh;
                }
                if (x != 0) {
                    sp = " ";
                } else {
                    sp = "";
                }
                line = line + sp + word;
                x = x + space + w;
                wordCount++;
            }
        }
        drawString(g, line, wordCount, fm.stringWidth(line), y + bl);
    }

    public void drawString(Graphics g, String line, int wordCount, int lineWidth, int y) {
        switch (align) {
            case LEFT:
                g.drawString(line, 0, y);
                break;
            case RIGHT:
                g.drawString(line, d.width - lineWidth, y);
                break;
            case CENTER:
                g.drawString(line, (d.width - lineWidth) / 2, y);
                break;
            case LEFTRIGHT:
                if (lineWidth < (int) (d.width * 0.75)) {
                    g.drawString(line, 0, y);
                } else {
                    int toFill = (d.width - lineWidth) / wordCount;
                    int nudge = d.width - lineWidth - (toFill * wordCount);
                    int s = fm.stringWidth(" ");
                    StringTokenizer st = new StringTokenizer(line);
                    int x = 0;
                    while (st.hasMoreTokens()) {
                        String word = st.nextToken();
                        g.drawString(word, x, y);
                        if (nudge > 0) {
                            x = x + fm.stringWidth(word) + space + toFill + 1;
                            nudge--;
                        } else {
                            x = x + fm.stringWidth(word) + space + toFill;
                        }
                    }
                }
                break;
        }
    }
}
