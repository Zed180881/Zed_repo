package part2.chapter27;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.StringTokenizer;

public class ImageFilterDemo extends Applet implements ActionListener {
    Image img;
    PlugInFilter pif;
    Image fImg;
    Image curImg;
    LoadedImage lIm;
    Label lab;
    Button reset;

    @Override
    public void init() {
        setLayout(new BorderLayout());
        Panel p = new Panel();
        add(p, BorderLayout.SOUTH);
        reset = new Button("Reset");
        reset.addActionListener(this);
        p.add(reset);
        StringTokenizer st = new StringTokenizer(getParameter("filters"), "+");
        while (st.hasMoreTokens()) {
            Button b = new Button(st.nextToken());
            b.addActionListener(this);
            p.add(b);
        }
        lab = new Label("");
        add(lab, BorderLayout.NORTH);
        try {
            img = getImage(new URL(getParameter("img")));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        lIm = new LoadedImage(img);
        add(lIm, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String a = "";
        a = e.getActionCommand();
        if (a.equals("Reset")) {
            lIm.set(img);
            lab.setText("Normal");
        } else {
            switch (a) {
                case "Grayscale":
                    pif = new Grayscale();
                    break;
                case "Invert":
                    pif = new Invert();
                    break;
                case "Contrast":
                    pif = new Contrast();
                    break;
                case "Blur":
                    pif = new Blur();
                    break;
                case "Sharpen":
                    pif = new Sharpen();
                    break;
            }
            fImg = pif.filter(this, img);
            lIm.set(fImg);
            lab.setText("Filtered: " + a);
        }
        repaint();
    }
}
