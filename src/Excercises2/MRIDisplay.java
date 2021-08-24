package Excercises2;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.io.FileNotFoundException;

public class MRIDisplay extends Plot implements KeyListener{

    private MRIData mriData;
    private int currentSlice;
    private int lastRememberedSlice = 1; //TODO: make this an array, so we can iterate backwards if we cannot display the current slice

    public MRIDisplay() throws FileNotFoundException {
        this.mriData = new MRIData();
        this.addKeyListener(this);
        this.currentSlice = 151;
        if (this.currentSlice < 1 || this.currentSlice > 316) {
            this.currentSlice = lastRememberedSlice;
            System.out.println("Values shouldn't be less than 1 or greater than 316");
        }
    }


    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        super.paintComponent(g);
        //create colour but do not instantiate it until we can set the rgb later
        Color color;
        int slice = currentSlice;

        // ------------------------------------------ HORIZONTAL DISPLAY SEE FIGURE 1 IN REASSESSMENT DOCUMENT ---------------------------------------
        //iterating through the 3d array, and setting a new RGB color and creating small rectangles that we can stretch to fit the current size of the jFrame
        for (int rows = 0; rows < this.mriData.getArrayOfMRI3D()[slice].length; rows++) {
            for (int columns = 0; columns < this.mriData.getArrayOfMRI3D()[slice][rows].length; columns++) {

                //this.setScaleX(0, this.getWidth());
                //this.setScaleY(0, this.getHeight());

                int x = this.scaleX(columns);
                int y = this.scaleY(rows);

                //as referenced in MRIDATA, by returning getIntensity 3 times we provide the greyscale values for the new colour.
                g.setColor(new Color(this.mriData.getIntensity3D(columns,rows,slice),this.mriData.getIntensity3D(columns,rows,slice),this.mriData.getIntensity3D(columns,rows,slice))); //need to return it 3 times >> for R,G,B grayscale
                g.fillRect(columns,rows,this.getWidth(),this.getHeight());
            }
        }

    }

    public void paintComponent2(Graphics graphics){

        Graphics2D g = (Graphics2D) graphics;
        super.paintComponent(g);
        Color color;
        int temp = this.mriData.getArrayOfMRI3D().length-1; //this is so we can hold the x axis as a constant when we take it away from rows
        int slice = currentSlice;

        // ------------------------------------------ VERTICAL DISPLAY SEE FIGURE 2 IN REASSESSMENT DOCUMENT ----------------------------------------

        //as in the horizontal display, we now iterate through the total number of slices first (z), and then the number rows (y) (considered as columns (x))
        //before, the z axis was the the constant, now instead, we color is assinged in this orientation - y >> x, z >> y, x >> z
        //as now the x axis is held constant, we go through the brain front/back (x constant) as opposed to up to down (z constant)

        for (int rows = 0; rows < this.mriData.getArrayOfMRI3D().length; rows++) {
            for (int columns = 0; columns < this.mriData.getArrayOfMRI3D()[rows].length; columns++) {


                int x = this.scaleX(columns);
                int y = this.scaleY(rows);

                //as referenced in MRIDATA, by returning getIntensity 3 times we provide the greyscale values for the new colour.
                g.setColor(new Color(this.mriData.getIntensity3D(slice,columns,temp-rows),this.mriData.getIntensity3D(slice,columns,temp-rows),this.mriData.getIntensity3D(slice,columns,temp-rows))); //need to return it 3 times >> for R,G,B grayscale
                g.fillRect(columns,rows,this.getWidth(),this.getHeight());

            }
        }

    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();

        if (keyCode == KeyEvent.VK_LEFT) {
            lastRememberedSlice = currentSlice;
            this.currentSlice = (getcurrentSlice() - 1);
        }

        if (keyCode == KeyEvent.VK_RIGHT) {
            lastRememberedSlice = currentSlice;
            setcurrentSlice(getcurrentSlice() + 1);
        }

        if (keyCode == KeyEvent.VK_UP) {
            //now we should access the current slice, and flip the z for an x, so we flip which way we display the information from the 3D array
            paintComponent2(getGraphics());
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }

    public int getcurrentSlice(){
        return this.currentSlice;
    }

    public void setcurrentSlice(int Slice){
        this.currentSlice = Slice;
    }

    public int getLastRememberedSlice() {
        return lastRememberedSlice;
    }

    public void setLastRememberedSlice(int lastRememberedSlice) {
        this.lastRememberedSlice = lastRememberedSlice;
    }

}