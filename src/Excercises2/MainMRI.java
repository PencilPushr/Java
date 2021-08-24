package Excercises2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;

public class MainMRI{

    public static void main(String[] args){

        JFrame j = new JFrame("Drawing");

        j.getContentPane().setPreferredSize(new Dimension(370,302)); //setting size
        j.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //Java will now exit and stop the program after being closed

        try{
            MRIDisplay mri = new MRIDisplay();
            j.add(mri);
        } catch (FileNotFoundException e){
            System.out.println("File not found!");
            e.printStackTrace();
        }

        j.setFocusable(true); //require focus inside the window for the keylistener
        j.requestFocusInWindow();
        j.pack(); //set window to setPreferredSize
        j.setVisible(true);

        System.out.println("Please use arrow keys to navigate; left or right to change slices, up to change viewpoint");

        while(true){
            try{
                j.repaint();
                Thread.sleep(100);
            }   catch (InterruptedException ignored){

            }
        }
    }
}
