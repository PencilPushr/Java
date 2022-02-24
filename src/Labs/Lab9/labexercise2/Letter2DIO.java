package Labs.Lab9.labexercise2;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Letter2DIO {

    private static final int maxX = 500,
                            maxY = 500;


    public static void writeRandomLetters(String filename, int noObjects) throws FileNotFoundException {
        //PrintWriter pw = new PrintWriter("~/" + filename + ".csv");
        ///home/averagejoe/IdeaProjects/Java/src/Labs/Lab9/labexercise2/
        PrintWriter pw = new PrintWriter("test.csv");
        StringBuilder sb = new StringBuilder();

        //List<String[]> items = new List<String[]>;
        //String[] temp;

        //Call temp in loop -> append them to items each iteration
        //after loop is finished should have filled out list of string arrays
        //Push items into the file using .writeAll()

        for (int i = 0; i < noObjects; i++) {
            //temp = new String[6]
            sb.append(generateRndChar());
            sb.append(",");
            sb.append(generateRndIntX());
            sb.append(",");
            sb.append(generateRndIntY());
            sb.append("\n");
            pw.write(sb.toString());
            sb.setLength(0); //clears the string, faster approach than just allocating "new StringBuilder";
            //items.add(temp);
        }

        //pw.write(items.toString());

        //output.close();
        pw.close();
    }

    public static Letter2D[] readLetters(String filename, int noOfLines) throws FileNotFoundException {
        Scanner s = new Scanner(new File(filename + ".csv"));
        Letter2D[] l2d = new Letter2D[noOfLines * 3]; //[noOflines*3] will give us the x,y and c values needed for the size of the array
        Letter2D temp;

        int tempX;
        int tempY;
        char tempC; //we will cast this later to char


        for (int i = 0; i < noOfLines; i++) {
            if (!s.hasNext()) break; //sanity check that we aren't trying to read an empty file
            String line = s.nextLine();
            tempC = line.charAt(0);
            tempX = Integer.parseInt(line.split(",")[1]);
            tempY = Integer.parseInt(line.split(",")[2]);
            temp = new Letter2D(tempX, tempY, tempC);
            l2d[i] = temp;
            //l2d[i].setC((char) tempC);
            //l2d[i].setX(tempX);
            //l2d[i].setY(tempY);
        }
        return l2d;
    }

    private static char generateRndChar(){
        Random r = new Random();
        //char c = (char)(r.nextInt(26) + 'a');
        return (char)(r.nextInt(26) + 'a');
    }

    private static int generateRndIntX(){
        return (0 + (int) (Math.random() * ((maxX - 0) + 1)));
    }

    private static int generateRndIntY(){
        return (0 + (int)(Math.random() * ((maxY - 0) + 1)));
    }
}
