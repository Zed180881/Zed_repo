package part3.chapter31;

import javax.swing.*;

class PaintDemo {

    PaintPanel paintPanel;

    PaintDemo() {
        JFrame jFrame = new JFrame("Paint demo");
        jFrame.setSize(200, 100);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        paintPanel = new PaintPanel();
        jFrame.add(paintPanel);
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PaintDemo();
            }
        });
    }
}
