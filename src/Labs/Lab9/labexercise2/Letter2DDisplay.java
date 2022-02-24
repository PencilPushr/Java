package Labs.Lab9.labexercise2;

import javax.swing.*;
import java.awt.*;

public class Letter2DDisplay extends JComponent {

    private Letter2D[] letterArray;

    Letter2DDisplay(Letter2D[] letterArray){
        this.letterArray = letterArray;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Color color;

        for (int i = 0; i < letterArray.length; i++) {
            g.setColor(Color.black);
            g.drawString(this.letterArray[i].getC(), this.letterArray[i].getX(), this.letterArray[i].getY());

        }
    }
}
