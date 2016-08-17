package part3.chapter31;

import javax.swing.*;

class SwingDemo {
    SwingDemo() {
        JFrame jFrame = new JFrame("A simple Swing application");
        jFrame.setSize(275, 100);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel jLabel = new JLabel("Swing means powerful GUIs.");
        jFrame.add(jLabel);
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SwingDemo();
            }
        });
    }
}
