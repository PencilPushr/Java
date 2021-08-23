package Excercises2;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;

public class MRIDisplay extends Plot{

    private MRIData mriData;
    private int currentSlice;
    private int lastRememberedSlice = 1;

    public MRIDisplay() throws FileNotFoundException {
        this.mriData = new MRIData();
        this.currentSlice = 1;
        if (this.currentSlice < 1 || this.currentSlice > 316) {
            this.currentSlice = lastRememberedSlice;
            System.out.println("Values shouldn't be less than 1 or greater than 316");
        }

        this.addKeyListener(new KeyListener() { //I am aware this should probably be in MainMRI, however I need to instantiate a new MRIdisplay each time.
            @Override
            public void keyTyped(KeyEvent keyEvent) {

            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                int keyCode = keyEvent.getKeyCode();

                if (keyCode == KeyEvent.VK_LEFT) {
                    lastRememberedSlice = getcurrentSlice();
                    setcurrentSlice(getcurrentSlice() - 1);
                }

                if (keyCode == KeyEvent.VK_RIGHT) {
                    lastRememberedSlice = getcurrentSlice();
                    setcurrentSlice(getcurrentSlice() + 1);
                }

                if (keyCode == KeyEvent.VK_UP) {
                    lastRememberedSlice = getcurrentSlice();
                    //now we should access the current slice, and flip the z for an x, so we flip which way we display the information from the 3D array
                }
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {

            }
        });
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

    public int getLastRememberedSlice() {
        return lastRememberedSlice;
    }

    public void setLastRememberedSlice(int lastRememberedSlice) {
        this.lastRememberedSlice = lastRememberedSlice;
    }
}