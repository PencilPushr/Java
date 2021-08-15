package Excercises2;

import javax.swing.*;

public class MainMRI {

    public static void main(String[] args) {

        JFrame j = new JFrame("Drawing");
        j.setSize(302,370);
        j.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        j.add(MRIDisplay);

        j.setVisible(true);
    }

}
