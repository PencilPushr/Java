package AppProgram.Assignment1.CE203AssignmentCode2223;

import javax.swing.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.util.ArrayList;


// ContainerPanel class for CE203 Assignment to use and modify if needed
// Date: 09/11/2022
// Author: F. Doctor

public class ContainerPanel extends JPanel{

    ContainerFrame conFrame;

    private ArrayList<PolygonContainer> pList;

    private JComboBox<String> polygonToDisplay;

    public ContainerPanel(ContainerFrame cf,ArrayList<PolygonContainer> pList) {

        conFrame = cf;   // reference to ContainerFrame object
        this.pList = plist
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D comp = (Graphics2D)g;   // You will need to use a Graphics2D objects for this
        //this may be wrong
        Dimension size = getSize(conFrame.getSize());        // You will need to use this Dimension object to get
                                           // the width / height of the JPanel in which the
                                           // Polygon is going to be drawn



        //INCOMPLETE
        //LINK https://duckduckgo.com/?t=ffab&q=dimension+get+the+height+and+width+of+the+jpanel&ia=web
        size.height = getHeight();
        size.width = getWidth();

        for (var i: pList) {
            if (i == )
            i.drawPolygon(comp, size);
        }

        // Based on which stored PolygonContainer object you want to be retrieved from the
        // ArrayList and displayed, the object would be accessed and its drawPolygon() method
        // would be called here.

    }
}
