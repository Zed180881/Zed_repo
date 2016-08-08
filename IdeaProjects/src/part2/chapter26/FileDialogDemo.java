package part2.chapter26;

import java.awt.*;

class FileDialogDemo {
    public static void main(String[] args) {
        Frame f = new SampleFrame("File Dialog Demo");
        f.setVisible(true);
        f.setSize(100, 100);
        FileDialog fd = new FileDialog(f, "File Dialog");
        fd.setVisible(true);
    }
}
