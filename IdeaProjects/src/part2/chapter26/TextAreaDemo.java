package part2.chapter26;

import java.applet.Applet;
import java.awt.*;

public class TextAreaDemo extends Applet {
    @Override
    public void init() {
        String val = "Features of Java 8\n" +
                "Here is a brief summary of the enhancements included with the Java 8 release:\n" +
                "Lambda Expression and Virtual Extension Methods\n" +
                "Highlighting feature of Java SE 8 is the implementation of Lambda expressions and supporting features to the Java programming language and platform.\n" +
                "Date and Time API\n" +
                "This new API will allow developers to handle date and time in a more natural, cleaner and easier to understand way.\n" +
                "Nashhorn JavaScript Engine\n" +
                "A new lightweight, high performance implementation of JavaScript engine is integrated to JDk and is available to Java applications via existing APIs.\n" +
                "Improved Security\n" +
                "Replacing the existing hand-maintained list of caller sensitive methods with a mechanism that accurately identifies such methods and allows their callers to be discovered reliably.";
        TextArea text = new TextArea(val, 10, 30);
        add(text);
    }
}
