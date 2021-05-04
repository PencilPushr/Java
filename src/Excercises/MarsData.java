package Excercises;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MarsData {

    public double[][] arrayOfMars;
    public static String filepath = ("/home/averagejoe/IdeaProjects/Java/Rocketman/src/Excercises/marsPolarMedium.csv");
    ///home/averagejoe/IdeaProjects/Java/Rocketman/src/Excercises/
    ///home/alex/Java/src/Excercises/marsPolarSmall.csv

    public static void main(String[] args) {
        System.out.println(readDataN3());

        JFrame j = new JFrame("Drawing");


    }

    //Not sure what is asked here. It is impossible to store the line of doubles in 1st dimension and then the 3 elements
    //it would cause an error because doubles cannot contain commas
    public static String[][] readDataN3(){
        String[][] splitElements = null;
        String lineSplit[] = new String[4];

        try {
            Scanner s = new Scanner(new File(filepath));
            String line;


            while (s.hasNextLine()) {
                line = s.nextLine();
                lineSplit[0] = line;
                lineSplit[1] = line.split(",")[0];
                lineSplit[2] = line.split(",")[1];
                lineSplit[3] = line.split(",")[2];

                System.out.println(Arrays.toString(lineSplit));

                String[][] splitElements = new String[splitElements.length][(splitElements.length) * 3];
            }

            s.close();
        }

        catch (FileNotFoundException e){
            System.out.println("File not found | " + filepath);
            e.printStackTrace();
        }
        return splitElements;
    }
}
