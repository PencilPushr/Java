package Labs.Lab9.labexercise3;

import javax.swing.*;

public class MyMain {

    public static void main(String[] args) {
        JFrame f = new JFrame("Keyboard Input");
        f.setSize(500,500);
        //MyComponent mc = new MyComponent();
        f.add(new MyComponent());
        f.setFocusable(true); //require focus inside the window for the keylistener
        f.requestFocusInWindow();
        f.pack(); //set window to setPreferredSize
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

}
