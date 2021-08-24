package Excercises2;

import javax.swing.*;
import java.awt.*;

public class MainLobe extends JFrame{

    public MainLobe(){
        BrainLobeGUI Bgui = new BrainLobeGUI();
        setTitle("MainLobe");
        getContentPane().setPreferredSize(new Dimension(500,500));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        add(Bgui);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainLobe();
    }

}
