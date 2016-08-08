package part2.chapter26;

import java.applet.Applet;
import java.awt.*;

public class BorderLayoutDemo extends Applet {
    @Override
    public void init() {
        setLayout(new BorderLayout());

        add(new Button("This is across the top."), BorderLayout.NORTH);
        add(new Label("The footer message might go here."), BorderLayout.SOUTH);
        add(new Button("Right"), BorderLayout.EAST);
        add(new Button("Left"), BorderLayout.WEST);

        String msg = "Lorem ipsum dolor sit amet, consectetur adipiscing elit\n" +
                "sed do eiusmod tempor incididunt ut labore et dolore magna\n" +
                "aliqua. Ut enim ad minim veniam, quis nostrud exercitation\n" +
                "ullamco laboris nisi ut aliquip ex ea commodo consequat.\n" +
                "Duis aute irure dolor in reprehenderit in voluptate velit\n" +
                "esse cillum dolore eu fugiat nulla pariatur. Excepteur sint\n" +
                "occaecat cupidatat non proident, sunt in culpa qui officia\n" +
                "deserunt mollit anim id est laborum.";
        add(new TextArea(msg), BorderLayout.CENTER);
    }
}
