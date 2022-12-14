package AppProgram.Assignment1.CE203AssignmentCode2223;

import javax.swing.*;
import java.awt.*;


// ContainerFrame class for CE203 Assignment to use and modify if needed
// Date: 11/11/2022
// Author: F. Doctor

// A skeleton JFrame class has been provided which you would need to modifiy to include the other GUI components
// data structre and functionality specified in the assignment specification
public class ContainerFrame extends JFrame{


    // Here I have provided an example of two PolygonContainer objects where the number of sides
    // and side length of the polygon are hardcoded.
    // These should be input from the application text fields where the user would type them in.
    // This would create new PolygonContainer objects that would be stored in and accessed from
    // an ArrayList data structure rather than be explicitly defined as below

    public void createComponents() {

        JPanel drawPanel = new ContainerPanel(this);
        add(drawPanel, BorderLayout.CENTER);
        add(new TextPanel(this, ), BorderLayout.CENTER);
        setSize(500, 500);
        setVisible(true);
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );	// Close action.
    }

    public static void main(String[] args) {
        ContainerFrame cFrame = new ContainerFrame();
        cFrame.createComponents();
    }

}
