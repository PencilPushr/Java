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

        MRIData mri = new MRIData();

        try{
            //mri.readData2D();
            mri.readData3D(151,152);
        }catch (FileNotFoundException | NumberFormatException e){
            e.printStackTrace();
        }

    }

    public void readData3D(int file1, int file2) throws FileNotFoundException {

        //Using the class TwoDimentionalArrayList, it would be possible to make this code more efficient but for now
        // this code shall suffice
        //TODO: come back and implement the usage of TWODimentionalArrayList

        ArrayList<ArrayList<ArrayList<Integer>>> array3D = new ArrayList<ArrayList<ArrayList<Integer>>>();
        ArrayList<ArrayList<Integer>> array2D;
        ArrayList<Integer> temparraylist;
        String[] tempString = null;

        Scanner s = null;

        //this should work as a for loop, for whatever reason it simply does not, this code will likely have to be modified.
        while (file1 != file2) {
            s = new Scanner(new File("/home/averagejoe/IdeaProjects/Java/Rocketman/src/Excercises2/mri/" + file1 +".csv"));

            array2D = new ArrayList<ArrayList<Integer>>();

            while(s.hasNext()){
                tempString = s.nextLine().split(",");
                temparraylist = new ArrayList<Integer>();
                for (int j = 0; j < tempString.length; j++) {
                    temparraylist.add(Integer.parseInt(tempString[j]));
                }
                array2D.add(temparraylist);
            }
            array3D.add(array2D);
            file1++;
        }
        s.close();


        for (int i = 0; i < array3D.size(); i++) {
            for (int j = 0; j < array3D.get(i).size(); j++) {
                for (int k = 0; k < array3D.get(i).get(j).size(); k++) {
                    System.out.print(array3D.get(i).get(j).get(k).toString());
                }
                System.out.println("/n");
            }
        }
    }


    public void readData2D() throws FileNotFoundException {
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

        //Scanner s = new Scanner(new File("/home/averagejoe/IdeaProjects/Java/Rocketman/src/Excercises2/mri/" + filename +".csv"));

        Scanner s = new Scanner(new File("/home/averagejoe/IdeaProjects/Java/Rocketman/src/Excercises2/mri/151.csv"));


        while(s.hasNext()){
            string = s.nextLine().split(",");
            temp = new ArrayList<Integer>();
            for (int i = 0; i < string.length; i++) {
                temp.add(Integer.parseInt(string[i]));
            }
            al.add(temp);
        }
        s.close();

        //al.toArray(this.arrayOfMRI2D);

        //System.out.println("NUMBER 9 LARGE, 2 NUMBER 5's...AND A LARGE SODA");
        for (int i = 0; i < al.size(); i++) {
            for (int j = 0; j < al.get(i).size(); j++) {
                System.out.print(al.get(i).get(j).toString());
            }
            System.out.println("/n");
        }


    }

    public int getIntensity2D(int x, int y){

        return this.arrayOfMRI2D[y][x];
    }

    public int getIntensity3D(int x, int y, int z){

        return this.arrayOfMRI3D[z][y][x];
    }

}
