package part2.chapter26;

import java.applet.Applet;
import java.awt.*;

public class GridLayoutDemo extends Applet {
    static final int n = 4;

    @Override
    public void init() {
        setLayout(new GridLayout(n, n));
        setFont(new Font("SansSerif", Font.BOLD, 24));
        for (int i = 0; i < n; i++) {
            for (int i1 = 0; i1 < n; i1++) {
                int k = i * n + i1;
                if (k > 0)
                    add(new Button("" + k));
            }
        }
    }
}
