package part3.chapter32;

import javax.swing.*;

class ColorsPanel extends JPanel {
    public ColorsPanel() {
        JCheckBox checkBox1 = new JCheckBox("Red");
        JCheckBox checkBox2 = new JCheckBox("Green");
        JCheckBox checkBox3 = new JCheckBox("Blue");
        add(checkBox1);
        add(checkBox2);
        add(checkBox3);
    }
}
