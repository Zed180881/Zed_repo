package part2.chapter27;

import java.awt.*;

public class LoadedImage extends Canvas {
    Image img;

    public LoadedImage(Image img) {
        set(img);
    }

    void set(Image img) {
        MediaTracker mt = new MediaTracker(this);
        mt.addImage(img, 0);
        try {
            mt.waitForAll();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
            return;
        }
        this.img = img;
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        if (img == null) {
            g.drawString("no image", 10, 30);
        } else {
            g.drawImage(img, 0, 0, this);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(img.getWidth(this), img.getHeight(this));
    }

    @Override
    public Dimension getMinimumSize() {
        return getPreferredSize();
    }
}
