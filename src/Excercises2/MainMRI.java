package Excercises2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;

public class MainMRI {

    MRIDisplay mri;

    public static void main(String[] args) {

        JFrame j = new JFrame("Drawing");

        KeyListener keyListener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {
                //j.setTitle("Key has been typed");
            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                int keyCode = keyEvent.getKeyCode();

                if (keyCode == KeyEvent.VK_LEFT){

                }

                if (keyCode == KeyEvent.VK_RIGHT){

                }
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {
                //j.setTitle("Key has been released");
            }
        };
        j.addKeyListener(keyListener);
        j.getContentPane().setPreferredSize(new Dimension(302,370)); //setting size
        j.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //Java will now exit and stop the program after being closed
        j.pack(); //set window to setPreferredSize
        j.setFocusable(true);
        j.requestFocusInWindow();
        try{
            j.add(new MRIDisplay());
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
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
