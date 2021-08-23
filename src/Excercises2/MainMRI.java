package Excercises2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;

public class MainMRI{

    MRIDisplay mri;

    public static void main(String[] args){

        JFrame j = new JFrame("Drawing");

        j.getContentPane().setPreferredSize(new Dimension(370,302)); //setting size
        j.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //Java will now exit and stop the program after being closed
        j.pack(); //set window to setPreferredSize
        j.setFocusable(true);
        j.requestFocusInWindow();
        try{
            MRIDisplay mri = new MRIDisplay();
            j.add(mri);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        System.out.println("Please use arrow keys to navigate; left or right to change slices, up to change viewpoint");

        j.setVisible(true);
        while(true){
            try{
                Thread.sleep(100);
            }   catch (InterruptedException ignored){

            }
            j.repaint();
        }
    }
}
