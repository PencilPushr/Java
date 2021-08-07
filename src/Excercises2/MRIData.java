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
    private static int[][][] arrayOfMRI3D;

    public static void main(String[] args) {

        MRIData mri = new MRIData();

        try{
            mri.readData2D();
        }catch (FileNotFoundException | NumberFormatException e){
            e.printStackTrace();
        }

    }




    public void readData2D() throws FileNotFoundException {

        //TwoDimentionalArrayList tdal = new TwoDimentionalArrayList();
        ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
        String[] string = null;
        ArrayList<Integer> temp;

        //ignore code, come back for less hardcoded stuff, when we have more ideas for better dynamic logic
        //goal -> read in and fill in reverse the 2d array. i.e.: this.array[j][i]
        //1. dynamically read in the file and return a temp for how many rows there are
        //2. assign temp to rows
        //3. initalise and return the temp2 of number of columns
        //4. assign temp2 to columns
        //5. fille number of rows with columns

        Scanner s = new Scanner(new File("/home/averagejoe/IdeaProjects/Java/Rocketman/src/Excercises2/mri/" + +".csv"));

        while(s.hasNext()){
            string = s.nextLine().split(",");
            temp = new ArrayList<Integer>();
            for (int i = 0; i < string.length; i++) {
                temp.add(Integer.parseInt(string[i]));
            }
            al.add(temp);
        }
        s.close();

        al.toArray(this.arrayOfMRI2D);

        /*System.out.println("NUMBER 9 LARGE, 2 NUMBER 5's...AND A LARGE SODA");
        for (int i = 0; i < al.size(); i++) {
            for (int j = 0; j < al.get(i).size(); j++) {
                System.out.print(al.get(i).get(j).toString());
            }
            System.out.println("/n");
        }*/


    }

    public int getIntensity2D(int x, int y){

        return this.arrayOfMRI2D[y][x];
    }

}
