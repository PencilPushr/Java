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

        Integer lowestAltitude = null;
        Integer highestAltitude = null;

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
                if(lowestAltitude == null){
                    lowestAltitude = temp[2];
                }else{
                    if (temp[2] < lowestAltitude){
                        lowestAltitude = temp[2];
                    }
                }
                if(highestAltitude == null){
                    highestAltitude = temp[2];
                }else{
                    if (temp[2] > highestAltitude){
                        highestAltitude = temp[2];
                    }
                }

                // we will need to do this for x and y values. according to matthew e.g. highestlongtitude, lowestlatitude etc...
                //assign it to 0FFFFFF or whatever

                //we then need to figure out how to map/convert out altitude to shades of grey.
                //pick out a fraction of 0 -> 1 and then have 1 set to white, 0 to black, then divide the altitude to get a number between 1 and 0
                //this will get our grey scale

                // use the highest and lowest values = this will gives you the 1, 0;

                //static java.awt.image.IndexColorModel 	getGray() works from 1 - 0
                //https://dhale.github.io/jtk/api/edu/mines/jtk/awt/ColorMap.html we can use this

                //Now, the row is ready.
                store.add(temp);
            }
            s.close();

            Integer[][] convertArr = new Integer[store.size()][store.size()];
            store.toArray(convertArr);

            return convertArr;
        }catch (FileNotFoundException e){//catch what?
            e.printStackTrace();
            return new Integer[0][0];
        }
    }


}
