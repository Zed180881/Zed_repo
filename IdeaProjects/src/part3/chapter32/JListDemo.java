package part3.chapter32;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class JListDemo extends JApplet {
    JList<String> jList;
    JLabel jLabel;
    JScrollPane jScrollPane;
    String[] cities = {"New York", "Chicago", "Houston", "Denver", "Los Angeles", "Seattle", "London", "Paris", "New Delhi", "Hong Kong", "Tokyo", "Sydney"};

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
        setLayout(new FlowLayout());
        jList = new JList<>(cities);
        jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jScrollPane = new JScrollPane(jList);
        jScrollPane.setPreferredSize(new Dimension(120, 90));
        jLabel = new JLabel("Choose a city");
        jList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int index = jList.getSelectedIndex();
                if (index != -1)
                    jLabel.setText("Current selection: " + cities[index]);
                else
                    jLabel.setText("Choose a city");
            }
        });
        add(jScrollPane);
        add(jLabel);
    }
}
