package Excercises2;

import java.awt.*;

public class MRIDisplay extends Plot{

    private MRIData mriData;
    Image image;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
    }
}
