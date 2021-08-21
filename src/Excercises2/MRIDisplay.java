package Excercises2;

import java.awt.*;
import java.io.FileNotFoundException;

public class MRIDisplay extends Plot{

    private MRIData mriData;
    private int currentSlice;
    Image image;

    public MRIDisplay() throws FileNotFoundException {
        this.mriData = new MRIData();
        this.currentSlice = 151;
    }

    public void GrayScaleGenerator(){
/*


        for (int i = 0; i < this.mriData.getIntensity3D(i,i,i); i++) {
            for (int j = 0; j < ; j++) {
                for (int k = 0; k < ; k++) {
                    mriData.getIntensity3D(i,j,k);
                }
            }
        }
*/

    }

    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
        Color color;

        int z = currentSlice;

        for (int y = 0; y < this.mriData.getArrayOfMRI3D()[z].length; y++) {
            for (int x = 0; x < this.mriData.getArrayOfMRI3D()[z][y].length; x++) {
                g.setColor(new Color(this.mriData.getIntensity3D(x,y,z))); // ITS IN FUCKING BLUE WHY!?!?!??!!?
                g.drawRect(x, y, 1, 1);
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
