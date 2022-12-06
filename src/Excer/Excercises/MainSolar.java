package Excer.Excercises;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ColorModel;

public class MainSolar {

    public static void main(String[] args) {

        JFrame j = new JFrame("Drawing");

        ColorModel o;
        o = j.getColorModel();
        //

        JComponent SolarDisplay = new SolarDisplay(600, 600);

        j.setSize(600, 600);
        //j.add(new Drawing());
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setVisible(true);
        j.setBackground(Color.white);




/*        while (true) {
            Thread.sleep(10);
            SolarDisplay.repaint();
        }*/
    }
}
