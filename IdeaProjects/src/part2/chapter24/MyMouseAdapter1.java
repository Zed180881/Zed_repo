package part2.chapter24;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class MyMouseAdapter1 extends MouseAdapter {
    MousePressedDemo mousePressedDemo;

    public MyMouseAdapter1(MousePressedDemo mousePressedDemo) {
        this.mousePressedDemo = mousePressedDemo;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        mousePressedDemo.showStatus("Mouse Pressed");
    }
}
