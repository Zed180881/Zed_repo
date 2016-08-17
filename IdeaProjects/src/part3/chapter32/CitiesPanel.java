package part3.chapter32;

import javax.swing.*;

class CitiesPanel extends JPanel {
    public CitiesPanel() {
        JButton b1 = new JButton("New York");
        JButton b2 = new JButton("London");
        JButton b3 = new JButton("Hong Kong");
        JButton b4 = new JButton("Tokyo");
        add(b1);
        add(b2);
        add(b3);
        add(b4);
    }
}
