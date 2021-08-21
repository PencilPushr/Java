package Excercises2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;

public class MainMRI {

    public static void main(String[] args) {

        JFrame j = new JFrame("Drawing");
        KeyListener keyListener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {
                j.setTitle("Key has been typed");
            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                j.setTitle("Key has been pressed");
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {
                j.setTitle("Key has been released");
            }
        };
        j.addKeyListener(keyListener);
        j.getContentPane().setPreferredSize(new Dimension(370,302)); //setting size
        j.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //Java will now exit and stop the program after being closed
        j.pack(); //set window to setPreferredSize
        try{
            j.add(new MRIDisplay());
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        j.setVisible(true);
        j.repaint();
    }

}
