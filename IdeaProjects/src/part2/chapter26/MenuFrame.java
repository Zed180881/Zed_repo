package part2.chapter26;

import java.awt.*;
import java.awt.event.*;

class MenuFrame extends Frame {
    String msg = "";
    CheckboxMenuItem debug, test;

    MenuFrame(String title) throws HeadlessException {
        super(title);

        MenuBar mBar = new MenuBar();
        setMenuBar(mBar);

        Menu file = new Menu("File");
        MenuItem item1, item2, item3, item4;
        file.add(item1 = new MenuItem("New..."));
        file.add(item2 = new MenuItem("Open..."));
        file.add(item3 = new MenuItem("Close"));
        file.add(new MenuItem("-"));
        file.add(item4 = new MenuItem("Quit..."));
        mBar.add(file);

        Menu edit = new Menu("Edit");
        MenuItem item5, item6, item7;
        edit.add(item5 = new MenuItem("Cut"));
        edit.add(item6 = new MenuItem("Copy"));
        edit.add(item7 = new MenuItem("Paste"));
        edit.add(new MenuItem("-"));
        debug = new CheckboxMenuItem("Debug");
        edit.add(debug);
        test = new CheckboxMenuItem("Testing");
        edit.add(test);
        mBar.add(edit);

        Menu sub = new Menu("Special");
        MenuItem item8, item9, item10;
        sub.add(item8 = new MenuItem("First"));
        sub.add(item9 = new MenuItem("Second"));
        sub.add(item10 = new MenuItem("Third"));
        mBar.add(sub);

        MyMenuHandler handler = new MyMenuHandler(this);
        item1.addActionListener(handler);
        item2.addActionListener(handler);
        item3.addActionListener(handler);
        item4.addActionListener(handler);
        item5.addActionListener(handler);
        item6.addActionListener(handler);
        item7.addActionListener(handler);
        item8.addActionListener(handler);
        item9.addActionListener(handler);
        item10.addActionListener(handler);
        debug.addActionListener(handler);
        test.addActionListener(handler);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setVisible(false);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(msg, 10, 200);
        if (debug.getState())
            g.drawString("Debug is on.", 10, 220);
        else
            g.drawString("Debug is off.", 10, 220);
        if (test.getState())
            g.drawString("Testing is on.", 10, 240);
        else
            g.drawString("Testing is off.", 10, 240);
    }

    class MyMenuHandler implements ActionListener, ItemListener {
        MenuFrame menuFrame;

        public MyMenuHandler(MenuFrame menuFrame) {
            this.menuFrame = menuFrame;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String arg = e.getActionCommand();
            msg = "You selected " + arg;
            if (arg.equals("New...")) {
                SampleDialog d = new SampleDialog(menuFrame, "New Dialog Box");
                d.setVisible(true);
            }
            repaint();
        }

        @Override
        public void itemStateChanged(ItemEvent e) {
            repaint();
        }
    }
}
