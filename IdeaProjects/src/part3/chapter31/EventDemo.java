package part3.chapter31;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class EventDemo {
    JLabel jLabel;

    EventDemo() {
        JFrame jFrame = new JFrame("An event example");
        jFrame.setLayout(new FlowLayout());
        jFrame.setSize(220, 90);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton jButtonAlpha = new JButton("Alpha");
        JButton jButtonBeta = new JButton("Beta");
        jButtonAlpha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jLabel.setText("Alpha was pressed.");
            }
        });
        jButtonBeta.addActionListener(al -> jLabel.setText("Beta was pressed."));

        jFrame.add(jButtonAlpha);
        jFrame.add(jButtonBeta);
        jLabel = new JLabel("Press a button.");
        jFrame.add(jLabel);
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EventDemo();
            }
        });
    }
}
