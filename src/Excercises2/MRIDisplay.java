package Excercises2;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class MRIDisplay extends Plot{

    private MRIData mriData;
    Image image;

    public MRIDisplay() throws FileNotFoundException {
        this.mriData = new MRIData();

    }

    public void GrayScaleGenerator(){


        for (int i = 0; i < this.mriData.getIntensity3D(i,i,i); i++) {
            for (int j = 0; j < ; j++) {
                for (int k = 0; k < ; k++) {
                    mriData.getIntensity3D(i,j,k);
                }
            }
        }

    }

    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
        Color color = new Color(150,150,150);
        g.setColor(color);
        g.drawRect(220, 200, 150, 150);
        g.fillRect(1,1,1,1);
    }
}
