package Excercises2;

import Excercises.MarsData;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MRIData {

    private int[][] arrayOfMRI2D;
    private int[][][] arrayOfMRI3D;

    public static void main(String[] args) {
        try{
            readData2D();
        }catch (FileNotFoundException | NumberFormatException e){
            e.printStackTrace();
        }

    }

    public static void readData2D() throws FileNotFoundException {

        /*TwoDimentionalArrayList tdal = new TwoDimentionalArrayList();
        List<String> al = new ArrayList<>();
        Integer[][] intarray = new Integer[302][370]; // hardcoded because I hate arraylists
        Integer[] temparray;
        String s1 = null;*/

        //ignore code, come back for less hardcoded stuff, when we have more ideas for better dynamic logic

        Scanner s = new Scanner(new File("/home/alex/Java/src/Excercises2/mri/mri/151.csv"));
       /*  s.useDelimiter(",");

        for (int i = 0; i < intarray.length; i++) {
            for (int j = 0; j < intarray[i].length; j++) {
                intarray[i][j] = Integer.parseInt(s.next());
            }
            intarray[i] =
        }

        while (true) {
            assert s != null;
            if (!s.hasNextLine()) break;
            Integer[] temp = new Integer[370];
            String line = s.nextLine();
            //Do each column, one by one.
            for (int i = 0; i < temp.length; i++) {
                String x = line.split(",")[i];
            }
        }*/

        //For Ben:
        //goal -> read in and fill in reverse the 2d array. i.e.: this.array[j][i]
        //1. dynamically read in the file and return a temp for how many rows there are
        //2. assign temp to rows
        //3. initalise and return the temp2 of number of columns
        //4. assign temp2 to columns
        //5. fille number of rows with columns


        int[][] matrix = new int[][]{{1},{2}};

        String line = new String(String.valueOf(new File(("/home/alex/Java/src/Excercises2/mri/mri/151.csv"))));
        while (s.hasNextLine()) {
            Scanner lineIn = new Scanner(line);
            //The initial case - this first line is used to determine the size of the array
            if (lineIn.hasNext()) {
                //Create a String array by splitting by spaces
                String[] sarr = lineIn.nextLine().trim().split(",");
                //Reinitialize the array to hold all of the subarrays
                matrix = new int[sarr.length][];
                for (int i = 0; i < sarr.length; i++) {
                    //Reinitialize each subarray to hold the numbers
                    matrix[i] = new int[i];
                    //Finally, parse your data from the String array
                    matrix[0][i] = Integer.parseInt(sarr[i]);
                }
            }
            //Repeat the steps now that all of your arrays have been initialized
            for (int j = 1; j < matrix.length; j++) {
                String[] sarr = lineIn.nextLine().trim().split("");
                for (int i = 0; i < sarr.length; i++) {
                    matrix[j][i] = Integer.parseInt(sarr[i]);
                }
            }
        }

        //it's numberFormatException, after recoding this entire bit 3-4 times, it appears it's numberFormat or NoSuchelement
        //it is dependent on whether we do nextline() or next()
        //Update: have tried buffereader and inputstream as well as combined them both with the use of inputstream reader, instead I get a nullpointer excption.


        System.out.println(Arrays.toString(matrix));

    }

    public int getIntensity2D(int coordinates){
        int temp = 0;

        return temp;
    }

}
