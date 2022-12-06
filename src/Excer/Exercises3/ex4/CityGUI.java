package Excer.Exercises3.ex4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CityGUI extends JComponent implements MouseListener {

    /*
    public CityGUI(){
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                e.getLocationOnScreen();
                //e.getX();
                //e.getY();
            }
        });
    }
    */



    public CityGUI() {
        addMouseListener(this);

    }


    @Override
    public void mouseClicked(MouseEvent e) {
        Graphics g = getGraphics();
        g.setColor(Color.black);
        String str = "X coordinates: " + e.getX() + ", Y coordinates: " + e.getY();
        System.out.println(str);
        // g.drawString(input, e.getX(), e.getY());
        //g.drawOval(e.getX(),e.getY(), e.get);
    }

    @Override
    public void mousePressed(MouseEvent e) {

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

