package Excer.Excercises;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class SolarDisplay extends JComponent {
    int width;
    int height;

    public SolarDisplay(int width, int height){
        this.width = width;
        this.height = height;
    }

    @Override
    public void paintComponent(Graphics graphics){
        Graphics2D g = (Graphics2D) graphics;
        AffineTransform StarSun = AffineTransform.getTranslateInstance(getWidth() / 2, getHeight() / 2);

        // Draw the sun
        g.setTransform(StarSun);
        //solarBodies(g, 80, Color.YELLOW);

        double percentRotation = System.currentTimeMillis() % 10000 / 10000.0;
        // To radians.
        double angle = -Math.PI * 2 * percentRotation;
    }

    //get the centre of rotations
    /*public void solarBodies(int distance, int angle, int diameter){
        double centreOfRotationX = (double) width / 2.0;
        double centreOfRotationY = (double) height / 2.0;
    }*/

}
