package Excercises;

import javax.swing.*;
import java.awt.*;

public class MarsDisplay extends Plot{

    private MarsData md = new MarsData();

    public static void main(String[] args) throws InterruptedException {
        JFrame j = new JFrame("Drawing");
        JComponent SolarDisplay = new SolarDisplay(600, 600);

        j.setSize(600, 600);
        j.add(new Drawing());
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setVisible(true);
        j.setBackground(Color.white);

        while (true) {
            Thread.sleep(10);
            SolarDisplay.repaint();
        }
    }
}
