package part3.chapter32;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

public class JTableDemo extends JApplet {
    @Override
    public void init() {
        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                @Override
                public void run() {
                    makeGUI();
                }
            });
        } catch (Exception e) {
            System.out.println("Can not create because of " + e);
        }
    }

    private void makeGUI() {
        String[] colHeads = {"Name", "Extension", "ID#"};
        Object[][] data = {
                {"Gail", "4567", "865"},
                {"Ken", "7556", "555"},
                {"Vivianne", "5634", "587"},
                {"Melanie", "7345", "922"},
                {"Anne", "1237", "333"},
                {"John", "5656", "314"},
                {"Matt", "5672", "217"},
                {"Claire", "6741", "444"},
                {"Erwin", "9023", "519"},
                {"Ellen", "1134", "532"},
                {"Jennifer", "5689", "532"},
                {"Ed", "9030", "133"},
                {"Helen", "6751", "145"}
        };
        JTable table = new JTable(data, colHeads);
        JScrollPane jScrollPane = new JScrollPane(table);
        add(jScrollPane);
    }
}
