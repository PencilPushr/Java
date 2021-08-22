package Excercises2;

import java.awt.*;
import java.io.FileNotFoundException;

public class MRIDisplay extends Plot{

    private MRIData mriData;
    private int currentSlice;

    public MRIDisplay() throws FileNotFoundException {
        this.mriData = new MRIData();
        this.currentSlice = 151;
        int[] lastRememberedSlice; //todo create a method so that everytime we go up or down, we remember the last slice before we went out of bounds;
        if (this.currentSlice < 1 || this.currentSlice > 316){
            this.currentSlice = 1; //set this to lastRememberedSlice
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

        //iterating through the 3d array, and setting a new RGB color and creating small rectangles that we can stretch to fit the current size of the jFrame
        for (int rows = 0; rows < this.mriData.getArrayOfMRI3D()[slice].length; rows++) {
            for (int columns = 0; columns < this.mriData.getArrayOfMRI3D()[slice][rows].length; columns++) {
                g.setColor(new Color(this.mriData.getIntensity3D(columns,rows,slice),this.mriData.getIntensity3D(columns,rows,slice),this.mriData.getIntensity3D(columns,rows,slice))); //need to return it 3 times >> for R,G,B grayscale
                g.drawRect(columns, rows, 1, 1);
                g.fillRect(1,1,1,1);
            }
        }

    }



    public int getcurrentSlice(){
        return this.currentSlice;
    }

    public void setcurrentSlice(int Slice){
        this.currentSlice = Slice;
    }

}