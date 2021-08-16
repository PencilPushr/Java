package Excercises2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
        j.getContentPane().setPreferredSize(new Dimension(302,370));
        //j.setSize(302,370);
        j.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        tr
        j.add(new MRIDisplay());
        j.setVisible(true);
        j.repaint();
    }

}
