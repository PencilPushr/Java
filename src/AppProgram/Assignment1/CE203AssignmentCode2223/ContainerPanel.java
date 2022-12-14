package AppProgram.Assignment1.CE203AssignmentCode2223;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;


// ContainerPanel class for CE203 Assignment to use and modify if needed
// Date: 09/11/2022
// Author: F. Doctor

public class ContainerPanel extends JPanel{

    ContainerFrame conFrame;

    public ContainerPanel(ContainerFrame cf) {

        conFrame = cf;   // reference to ContainerFrame object
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D comp = (Graphics2D)g;   // You will need to use a Graphics2D objects for this
        //this may be wrong
        Dimension size = getSize(conFrame.getSize());        // You will need to use this Dimension object to get
                                           // the width / height of the JPanel in which the
                                           // Polygon is going to be drawn

        PolygonContainer p = new PolygonContainer();

        //INCOMPLETE
        //LINK https://duckduckgo.com/?t=ffab&q=dimension+get+the+height+and+width+of+the+jpanel&ia=web
        size.height = getHeight();
        size.width = getWidth();

        p.drawPolygon(comp, size);

        // Based on which stored PolygonContainer object you want to be retrieved from the
        // ArrayList and displayed, the object would be accessed and its drawPolygon() method
        // would be called here.

    }
}
