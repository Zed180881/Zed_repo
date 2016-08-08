package part2.chapter24;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

class MyMouseMotionAdapter extends MouseMotionAdapter {
    AdapterDemo adapterDemo;

    public MyMouseMotionAdapter(AdapterDemo adapterDemo) {
        this.adapterDemo = adapterDemo;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        adapterDemo.showStatus("Mouse Dragged");
    }
}
