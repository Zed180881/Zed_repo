package part3.chapter32;

import javax.swing.*;

class FlavorsPanel extends JPanel {
    public FlavorsPanel() {
        JComboBox<String> jComboBox = new JComboBox<>();
        jComboBox.addItem("Vanilla");
        jComboBox.addItem("Chocolate");
        jComboBox.addItem("Strawberry");
        add(jComboBox);
    }
}
