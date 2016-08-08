package part2.chapter27;

import java.applet.Applet;
import java.awt.*;

interface PlugInFilter {
    Image filter(Applet a, Image in);
}
