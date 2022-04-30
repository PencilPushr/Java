package Exercises3.ex3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PopulationData {

    private double[][] popData;

    public PopulationData(String filename) throws FileNotFoundException {
        //Initalise popData to x and y pixel array lengths
        popData = new double[8640][4320];

        //utility variables
        int i = 0;
        double rnTotal = 0;

        //read in the file
        Scanner s = new Scanner(new File(filename));
        while(s.hasNext()){
            if(i == 5){
                String[] line = s.nextLine().split(",");
                for (int j = 0; j < line.length; j++) {
                    double temp = 0;
                    if (rnTotal < temp){
                        rnTotal = temp;
                    }
                }
                //popData[][]
            }

            i++;
        }
        System.out.println(rnTotal);

    }

    //create function for running total that indexes the value for the colour range.


    public double[][] getPopData() {
        return popData;
    }
}
