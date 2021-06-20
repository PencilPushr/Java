package Excercises;

import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MarsData {

    public double[][] arrayOfMars;
    public static String filepath = ("/home/alex/Java/src/Excercises/marsPolarMedium.csv");
    ///home/averagejoe/IdeaProjects/Java/Rocketman/src/Excercises/
    ///home/alex/Java/src/Excercises/marsPolarSmall.csv

    public static void cheese() {
        Integer[][] marsMap = readMarsData();

        //JFrame j = new JFrame("Drawing");
        System.out.println("Testerisng");

    }

    //We are assuming that all the values can be multiplied by 1000 and then by 5 (or same as 200) -> for the y values only
    //We assume that all the values can be multiplied by 100 -> for x values only
    //We can always convert this data into an integer from a double without losing data

    //this is lossless, because we can simply divide by 200 for y and 100 for x

    //because of the way we are making this cartesian grid there will be gaps, so be mindful when mapping this.
    public static Integer[][] readMarsData(){
        ArrayList<Integer[]> store = new ArrayList<Integer[]>();
        Scanner s = null;

        try{
            s = new Scanner(new File(MarsData.filepath));
            while (true){
                assert s != null;
                if (!s.hasNextLine()) break;
                Integer[] temp = new Integer[3];
                String line = s.nextLine();
                //Do each column, one by one.
                String x = line.split(",")[0];
                String y = line.split(",")[1];
                String z = line.split(",")[2];
                //Here, we get the x coordinate.
                temp[0] = (int) (Double.parseDouble(x)*200);
                //Here, we get the y coordiante.
                temp[1] = (int) (Double.parseDouble(y)*100);
                //Here, we get the z coordiante.
                temp[2] = Integer.parseInt(z);
                //Now, the row is ready.
                store.add(temp);
            }
            s.close();
            return (Integer[][]) store.toArray();
        }catch (FileNotFoundException e){//catch what?
            e.printStackTrace();
            return new Integer[0][0];
        }

    }
}
