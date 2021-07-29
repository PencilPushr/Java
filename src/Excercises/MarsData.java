package Excercises;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MarsData {

    HoldingThingy holdingThingy = new HoldingThingy();

    private HoldingThingy.holdingThingy holderino;
    public static String filepath = ("/home/alex/Java/src/Excercises/marsPolarMedium.csv");
    ///home/averagejoe/IdeaProjects/Java/Rocketman/src/Excercises/
    ///home/alex/Java/src/Excercises/marsPolarSmall.csv

    public static void cheese() {
        //Integer[][] marsMap = readMarsData();
        HoldingThingy.holdingThingy marsMap = readData2D();

        //JFrame j = new JFrame("Drawing");
        System.out.println("Testerisng");
    }

    //*4 for x and y values to turn them into ints and not floating points
    //this is lossless, because we can simply divide by 4

    //because of the way we are making this cartesian grid there will be gaps, so be mindful when mapping this.
    public static HoldingThingy.holdingThingy readData2D(){
        ArrayList<Integer[]> store = new ArrayList<Integer[]>();
        Scanner s = null;

        Integer lowestAltitude = null;
        Integer highestAltitude = null;

        Integer lowestLong = null;
        Integer highestLong = null;

        Integer lowestLat = null;
        Integer highestLat = null;

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
                temp[0] = (int) (Double.parseDouble(x)*4);
                //Here, we get the y coordiante.
                temp[1] = (int) (Double.parseDouble(y)*4);
                //Here, we get the z coordiante.
                temp[2] = Integer.parseInt(z);

                //altitude ----------------------------------------
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
                //longitude --------------------------------------
                if(lowestLong == null){
                    lowestLong = temp[1];
                }else{
                    if (temp[1] < lowestLong){
                        lowestLong = temp[1];
                    }
                }
                if(highestLong == null){
                    highestLong = temp[1];
                }else{
                    if (temp[1] > highestLong){
                        highestLong = temp[1];
                    }
                }

                //latitude -------------------------------------
                if(lowestLat == null){
                    lowestLat = temp[0];
                }else{
                    if (temp[0] < lowestLat){
                        lowestLat = temp[0];
                    }
                }
                if(highestLat == null){
                    highestLat = temp[0];
                }else{
                    if (temp[0] > highestLat){
                        highestLat = temp[0];
                    }
                }

                // we will need to do this for x and y values. according to matthew e.g. highestlongtitude, lowestlatitude etc...
                //assign it to 0FFFFFF or whatever

                //we then need to figure out how to map/convert out altitude to shades of grey.
                //pick out a fraction of 0 -> 1 and then have 1 set to white, 0 to black, then divide the altitude to get a number between 1 and 0
                //this will get our grey scale

                // use the highest and lowest values = this will gives you the 1, 0;

                //Now, the row is ready.
                store.add(temp);
            }
            s.close();

            Integer[][] convertArr = new Integer[store.size()][store.size()];
            store.toArray(convertArr);

            //h.ma

            HoldingThingy.holdingThingy h = new HoldingThingy.holdingThingy();
           // h.arrayOfMars = convertArr;

            return h;
        }catch (FileNotFoundException e){//catch what?
            e.printStackTrace();
            //return new Integer[0][0];
            return new HoldingThingy.holdingThingy();
        }
    }


}

