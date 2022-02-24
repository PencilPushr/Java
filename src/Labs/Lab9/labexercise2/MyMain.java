package Labs.Lab9.labexercise2;

import javax.swing.*;
import java.io.FileNotFoundException;

public class MyMain {

    public static void main(String[] args) {
        Letter2DIO l2dio = new Letter2DIO();
        try{
            l2dio.writeRandomLetters("test", 10);
            l2dio.readLetters("test",10);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        JFrame f = new JFrame("Letter2D Display");
        f.setSize(500,500);
        try{
            f.add(new Letter2DDisplay(Letter2DIO.readLetters("test", 100)));
        } catch (FileNotFoundException g){
            g.printStackTrace();
        }
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

}
