package Labs.Lab9.labexercise2;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Random;

public class Letter2DIO {

    private static final int maxX = 500,
                            maxY = 500;


    public static void writeRandomLetters(String filename, int noObjects) throws FileNotFoundException {
        PrintStream output = new PrintStream(filename);
        for (int i = 0; i < noObjects; i++) {
            //output.println(math.random); -- placeholder
        }
        output.close();
    }

    public static Letter2D[] readLetters(String filename, int noOfLines){

        return new Letter2D[0];
    }

    private char generateRndChar(){
        Random r = new Random();
        //char c = (char)(r.nextInt(26) + 'a');
        return (char)(r.nextInt(26) + 'a');
    }
}
