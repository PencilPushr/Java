package Exercises3.ex3;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class PopulationDisplay extends JComponent{

    private PopulationData[] pdata;

    public PopulationDisplay(String[] filename){
        this.pdata = new PopulationData[filename.length];

        for (int i = 0; i < filename.length; i++) {
            try {
                this.pdata[i] = new PopulationData(filename[i]);
            }catch (FileNotFoundException e){
                System.out.println("File not found");
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        super.paintComponent(g);
        int counter = 0;
        Color color;

        while(true){ //implement a 5 second sleep cycle for cycling through the popdata files
            try {
                //render file to display to Jframe
                //override Colour to display a gradient of values

                //perhaps use the getPopIntensity method to make more readable
                for (int i = 0; i < this.pdata[0].getPopData().length; i++) {
                    for (int j = 0; j < this.pdata[0].getPopData()[0].length; j++) {
                        double[] temp1 = this.pdata[i].IndexedColour(i, j);
                        g.setColor(new Color((float) temp1[0], (float) temp1[1], (float) temp1[2]));
                        g.fillRect(i, j, this.getWidth(), this.getHeight());
                    }
                }

                if (counter > pdata.length){
                    counter = 0;
                }

                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
