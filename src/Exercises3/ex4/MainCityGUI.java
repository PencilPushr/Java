package Exercises3.ex4;

import Labs.Lab9.labexercise3.MyComponent;

import javax.swing.*;

public class MainCityGUI {

    public static void main(String[] args) {
        JFrame f = new JFrame("Keyboard Input");
        f.setSize(750,750);
        //f.add(new CityGUI());
        f.setFocusable(true); //require focus inside the window for the MouseListener
        f.requestFocusInWindow();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
