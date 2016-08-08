package part2.chapter24;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class MyMouseAdapter extends MouseAdapter {
    AdapterDemo adapterDemo;

    public MyMouseAdapter(AdapterDemo adapterDemo) {
        this.adapterDemo = adapterDemo;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        adapterDemo.showStatus("Mouse Clicked");
    }
}
