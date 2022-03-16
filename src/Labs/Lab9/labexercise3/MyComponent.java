package Labs.Lab9.labexercise3;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyComponent extends JComponent implements MouseListener, KeyListener {

    public MyComponent(){
        this.addKeyListener(this);
        this.addMouseListener(this);
    }


    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("Pressed " + e.getKeyChar()); //get which key was pressed
        //https://docs.oracle.com/javase/7/docs/api/java/awt/event/KeyEvent.html#getKeyChar
        //according to docs, getKeyChar will only be meaningful in keyTyped()
        //pressing F1 key will not result in a unicode character being printed
        //likewise shift is a modifier key and will not be printed.
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("Pressed " + e.getButton()); //get which button was pressed
        //https://docs.oracle.com/javase/7/docs/api/java/awt/event/MouseEvent.html
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
