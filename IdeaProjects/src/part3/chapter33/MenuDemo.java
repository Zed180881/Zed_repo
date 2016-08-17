package part3.chapter33;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MenuDemo implements ActionListener {
    JLabel jLabel;
    JMenuBar jMenuBar;
    JToolBar jToolBar;
    JPopupMenu jPopupMenu;
    DebugAction setAct;
    DebugAction clearAct;
    DebugAction resumeAct;

    MenuDemo() {
        JFrame jFrame = new JFrame("Complete Menu Demo");

        jFrame.setSize(360, 200);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jLabel = new JLabel();

        jMenuBar = new JMenuBar();

        makeFileMenu();

        makeActions();

        makeToolBar();

        makeOptionsMenu();

        makeHelpMenu();

        makeEditPUMenu();

        jFrame.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger())
                    jPopupMenu.show(e.getComponent(), e.getX(), e.getY());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger())
                    jPopupMenu.show(e.getComponent(), e.getX(), e.getY());
            }
        });

        jFrame.add(jLabel, SwingConstants.CENTER);

        jFrame.add(jToolBar, BorderLayout.NORTH);

        jFrame.setJMenuBar(jMenuBar);

        jFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comString = e.getActionCommand();
        if (comString.equals("Exit"))
            System.exit(0);
        jLabel.setText(comString + " Selected");
    }

    void makeEditPUMenu() {
        jPopupMenu = new JPopupMenu();
        JMenuItem jMenuItemCut = new JMenuItem("Cut");
        JMenuItem jMenuItemCopy = new JMenuItem("Copy");
        JMenuItem jMenuItemPaste = new JMenuItem("Paste");
        jPopupMenu.add(jMenuItemCut);
        jPopupMenu.add(jMenuItemCopy);
        jPopupMenu.add(jMenuItemPaste);
        jMenuItemCut.addActionListener(this);
        jMenuItemCopy.addActionListener(this);
        jMenuItemPaste.addActionListener(this);
    }

    void makeHelpMenu() {
        JMenu jMenuHelp = new JMenu("Help");
        ImageIcon imageIconAbout = new ImageIcon("info.png");
        JMenuItem jMenuItemAbout = new JMenuItem("About", imageIconAbout);
        jMenuItemAbout.setToolTipText("Info about the Menu Demo program.");
        jMenuHelp.add(jMenuItemAbout);
        jMenuBar.add(jMenuHelp);
        jMenuItemAbout.addActionListener(this);
    }

    void makeOptionsMenu() {
        JMenu jMenuOptions = new JMenu("Options");

        JMenu jMenuColors = new JMenu("Colors");
        JCheckBoxMenuItem jMenuItemRed = new JCheckBoxMenuItem("Red");
        JCheckBoxMenuItem jMenuItemGreen = new JCheckBoxMenuItem("Green");
        JCheckBoxMenuItem jMenuItemBlue = new JCheckBoxMenuItem("Blue");
        jMenuColors.add(jMenuItemRed);
        jMenuColors.add(jMenuItemGreen);
        jMenuColors.add(jMenuItemBlue);
        jMenuOptions.add(jMenuColors);

        JMenu jMenuPriority = new JMenu("Priority");
        JRadioButtonMenuItem jMenuItemHigh = new JRadioButtonMenuItem("High", true);
        JRadioButtonMenuItem jMenuItemLow = new JRadioButtonMenuItem("Low");
        jMenuPriority.add(jMenuItemHigh);
        jMenuPriority.add(jMenuItemLow);
        jMenuOptions.add(jMenuPriority);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(jMenuItemHigh);
        buttonGroup.add(jMenuItemLow);

        JMenu jMenuDebug = new JMenu("Debug");
        JMenuItem jMenuItemSetBP = new JMenuItem(setAct);
        JMenuItem jMenuItemClearBP = new JMenuItem(clearAct);
        JMenuItem jMenuItemResume = new JMenuItem(resumeAct);
        jMenuDebug.add(jMenuItemSetBP);
        jMenuDebug.add(jMenuItemClearBP);
        jMenuDebug.add(jMenuItemResume);
        jMenuOptions.add(jMenuDebug);

        JMenuItem jMenuItemReset = new JMenuItem("Reset");
        jMenuOptions.addSeparator();
        jMenuOptions.add(jMenuItemReset);

        jMenuBar.add(jMenuOptions);

        jMenuItemRed.addActionListener(this);
        jMenuItemGreen.addActionListener(this);
        jMenuItemBlue.addActionListener(this);
        jMenuItemHigh.addActionListener(this);
        jMenuItemLow.addActionListener(this);
        jMenuItemReset.addActionListener(this);
    }

    void makeToolBar() {
        jToolBar = new JToolBar("Breakpoints");
        JButton jButtonSet = new JButton(setAct);
        JButton jButtonClear = new JButton(clearAct);
        JButton jButtonResume = new JButton(resumeAct);

        jToolBar.add(jButtonSet);
        jToolBar.add(jButtonClear);
        jToolBar.add(jButtonResume);
    }

    void makeActions() {
        ImageIcon setIcon = new ImageIcon("toggle_breakpoint_icon.gif");
        ImageIcon clearIcon = new ImageIcon("clear_breakpoints_icon.gif");
        ImageIcon resumeIcon = new ImageIcon("resume_icon.gif");
        setAct = new DebugAction("Set Breakpoint", setIcon, KeyEvent.VK_S, KeyEvent.VK_B, "Set a breakpoint.");
        clearAct = new DebugAction("Clear Breakpoint", clearIcon, KeyEvent.VK_C, KeyEvent.VK_L, "Clear a breakpoint.");
        resumeAct = new DebugAction("Resume", resumeIcon, KeyEvent.VK_R, KeyEvent.VK_R, "Resume execution after breakpoint.");
        clearAct.setEnabled(false);
    }

    void makeFileMenu() {
        JMenu jMenuFile = new JMenu("File");
        jMenuFile.setMnemonic(KeyEvent.VK_F);
        JMenuItem jMenuItemOpen = new JMenuItem("Open", KeyEvent.VK_O);
        jMenuItemOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
        JMenuItem jMenuItemClose = new JMenuItem("Close", KeyEvent.VK_C);
        jMenuItemClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
        JMenuItem jMenuItemSave = new JMenuItem("Save", KeyEvent.VK_S);
        jMenuItemSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        JMenuItem jMenuItemExit = new JMenuItem("Exit", KeyEvent.VK_E);
        jMenuItemExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
        jMenuFile.add(jMenuItemOpen);
        jMenuFile.add(jMenuItemClose);
        jMenuFile.add(jMenuItemSave);
        jMenuFile.addSeparator();
        jMenuFile.add(jMenuItemExit);
        jMenuBar.add(jMenuFile);

        jMenuItemOpen.addActionListener(this);
        jMenuItemClose.addActionListener(this);
        jMenuItemSave.addActionListener(this);
        jMenuItemExit.addActionListener(this);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MenuDemo();
            }
        });
    }

    class DebugAction extends AbstractAction {
        public DebugAction(String name, Icon icon, int mnemonic, int accelerator, String tooltip) {
            super(name, icon);
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(accelerator, InputEvent.CTRL_DOWN_MASK));
            putValue(MNEMONIC_KEY, new Integer(mnemonic));
            putValue(SHORT_DESCRIPTION, tooltip);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String comString = e.getActionCommand();
            jLabel.setText(comString + " Selected");
            if (comString.equals("Set Breakpoint")) {
                clearAct.setEnabled(true);
                setAct.setEnabled(false);
            } else if (comString.equals("Clear Breakpoint")) {
                clearAct.setEnabled(false);
                setAct.setEnabled(true);
            }
        }
    }
}
