package Exercises3.ex3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class PopulationData {

    private double[][] popData;

    public PopulationData(String filename) throws FileNotFoundException {
        //Initalise popData to x and y pixel array lengths
        //should be 4320 columns however we skip the first 5 rows
        popData = new double[4314][8640];

        //utility variables
        int i = 0;
        double rnTotal = 0.0d;

        //read in the file
        Scanner s = new Scanner(new File(filename));

        while(s.hasNext()){
            String thing = s.nextLine();

            if(i >= 6){
                String[] line = thing.split("\\s");
                for (int j = 0; j < line.length; j++) {

                    this.popData[i][j] = Double.parseDouble(line[j]);

                    //running total
                    if (rnTotal < Double.parseDouble(line[j])){
                        rnTotal = Double.parseDouble(line[j]);
                    }
                }
            }

            i++;
        }

        //alternatively using something like Collections class, could skip the first 5 lines and simply bulk add
        //the entirety of the CSV to a 2d double array

    }

    //create function for running total that indexes the value for the colour range.
    public void IndexedColour(double total){

    }


    public double[][] getPopData() {
        return popData;
    }
}
