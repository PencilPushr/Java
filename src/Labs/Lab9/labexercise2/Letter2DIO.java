package Labs.Lab9.labexercise2;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Letter2DIO {

    private static final int maxX = 500,
                            maxY = 500;


    public static void writeRandomLetters(String filename, int noObjects) throws FileNotFoundException {
        //PrintStream output = new PrintStream(filename);
        PrintWriter pw = new PrintWriter(filename + ".csv");
        StringBuilder sb = new StringBuilder();
        //List<String[]> items = new List<String[]>;
        //String[] temp
        //alternatively using temp I can append them to items and then once I have all the arrays of objects
        //put them in items and then push them into the file.

        for (int i = 0; i < noObjects; i++) {
            sb.append(generateRndIntX());
            sb.append(",");
            sb.append(generateRndIntY());
            sb.append(",");
            sb.append(generateRndChar());
            sb.append("\n");
            pw.write(sb.toString());
        }
        //output.close();
        pw.close();
    }

    public static Letter2D[] readLetters(String filename, int noOfLines){
        Scanner s = new Scanner(filename);
        for (int i = 0; i < noOfLines; i++) {

        }
        return new Letter2D[0];
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
