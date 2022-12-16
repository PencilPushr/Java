package AppProgram.Assignment1.CE203AssignmentCode2223;

import java.awt.*;
import java.util.Arrays;

import static java.lang.Math.PI;


// Incomplete PolygonContainer class for CE203 Assignment
// Date: 11/11/2022
// Author: F. Doctor

public class PolygonContainer implements Comparable<PolygonContainer>{

    Color pColor = Color.BLACK; // Colour of the polygon, set to a Colour object, default set to black
    int pId = 000000;    // Polygon ID should be a six digit non-negative integer
    int pSides;         // Number of sides of the polygon, should be non-negative value
    int pSideLengths;   // Length of each side in pixels of the polygon, should be non-negative value
    int polyCenX;    // x value of centre point (pixel) of polygon when drawn on the panel
    int polyCenY;    // y value of centre point (pixel of polygon when drawn on the panel
    int [] pointsX;  // int array containing x values of each vertex (corner point) of the polygon
    int [] pointsY;  // int array containing y values of each vertex (corner point) of the polygon

    // Constructor currently set the number of sides and the equal length of each side of the Polygon
    // You will need to modify the constructor to set the pId and pColour fields.
    public PolygonContainer(int pSides, int pSideLengths, int pId, Color pColor) {

        this.pSides = pSides;             // user defined number of sides should be non-negative
        this.pSideLengths = pSideLengths; // user defined side length should be non-negative
        this.pId = pId;
        this.pColor = pColor;


        pointsX = new int[pSides];
        pointsY = new int[pSides];
        
    }

    //public int sanitisePIDinput(int id){}

    //public Color sanitisePColorinput(Color pColor){    }

    // Used to populate the points array with the vertices corners (points) and construct a polygon with the
    // number of sides defined by pSides and the length of each side defined by pSideLength.
    // Dimension object that is passed in as an argument is used to get the width and height of the AppProgram.Assignment1.CE203AssignmentCode2223.ContainerPanel
    // and used to determine the x and y values of its centre point that will be used to position the drawn Polygon.
    private Polygon getPolygonPoints(Dimension dim) {

        polyCenX = dim.width / 2;          // x value of centre point of the polygon
        polyCenY = dim.height / 2;         // y value of centre point of the polygon
        Polygon p = new Polygon();         // Polygon to be drawn

        // Using a for loop build up the points of polygon and iteratively assign then to the arrays
        // of points above. Use the following equation, make sure the values are cast to (ints)

        // ith x point  = x centre point  + side length * cos(2.0 * PI * i / sides)
        // ith y point  = y centre point  + side length * sin(2.0 * PI * i / sides)

        // To get cos use the Math.cos() class method
        // To get sine use the Math.sin() class method
        // to get PI use the constant Math.PI

        // Add the ith x and y points to the arrays pointsX[] and pointsY[]
        // Call addPoint() method on Polygon with arguments ith index of points
        // arrays 'pointsX[i]' and 'pointsY[i]'

        for (int i = 0; i < pSides; i++) {
            pointsX[i] = (int) (this.polyCenX + this.pSideLengths * Math.cos(2.0 * PI * i / this.pSides));
            pointsY[i] = (int) (this.polyCenX + this.pSideLengths * Math.sin(2.0 * PI * i / this.pSides));
        }

        p.xpoints = pointsX;
        p.ypoints = pointsY;
        p.npoints = pSides;

        return p;
    }



    // You will need to modify this method to set the colour of the Polygon to be drawn
    // Remember that Graphics2D has a setColor() method available for this purpose
    public void drawPolygon(Graphics2D g, Dimension d) {
        g.setColor(this.pColor);
        g.drawPolygon(getPolygonPoints(d));
    }


    // gets a stored ID
    public int getID() {
        return pId;
    }


    @Override
    // method used for comparing PolygonContainer objects based on stored ids, you need to complete the method
    public int compareTo(PolygonContainer o) {
        //realised java will throw its own exception if this is null, no need to do anything if it is null.
        //if (o == null) throw new NullPointerException("Inputted PolygonContainer object is null");
        return ( (this.pId > o.pId) ? ( (this.pId < o.pId) ? -1 : 1): 0);
    }


    // outputs a string representation of the PolygonContainer object, you need to complete this to use for testing
    public String toString()
    {
        return "This polgyons pId is :" + this.pId + "\n" +
                "Colour: " + this.pId + "\n" +
                "Sides:" + this.pId + "\n" +
                "Side lengths: " + this.pId + "\n" +
                "Centred at: " + this.polyCenX + " , " + this.polyCenY + "\n" +
                "With points:" + "\n" + "x:" + Arrays.toString(this.pointsX) + "\n" +
                                        "y:" + Arrays.toString(this.pointsY) + "\n";
    }
}
