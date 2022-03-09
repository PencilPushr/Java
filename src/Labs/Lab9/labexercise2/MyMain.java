package Labs.Lab9.labexercise2;

import javax.swing.*;
import java.io.FileNotFoundException;

public class MyMain {

    public static void main(String[] args) {
        //Letter2DIO l2dio = new Letter2DIO();
        try{
            Letter2DIO.writeRandomLetters("test", 10);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        JFrame f = new JFrame("Letter2D Display");
        f.setSize(500,500);
        try{
            f.add(new Letter2DDisplay(Letter2DIO.readLetters("test", 10)));
        } catch (FileNotFoundException g){
            g.printStackTrace();
        }
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    /*
    Integer[] accounts = new Integer[4];
account[0] = new Integer(1234);
account[1] = new Integer(5678);
     */

}
