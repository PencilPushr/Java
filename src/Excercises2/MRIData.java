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

    public void readData3D(int file1, int file2) throws FileNotFoundException, NullPointerException {

        //Using the class TwoDimentionalArrayList, it would be possible to make this code more efficient but for now
        // this code shall suffice
        //TODO: come back and implement the usage of TWODimentionalArrayList

        ArrayList<ArrayList<ArrayList<Integer>>> array3D = new ArrayList<ArrayList<ArrayList<Integer>>>();
        ArrayList<ArrayList<Integer>> array2D;
        ArrayList<Integer> temparraylist;
        String[] tempString = null;
        int temp1 = 0;
        int temp2 = 0;
        int temp3 = 0;

        Scanner s = null;


        for (int i = file1; i <= file2; i++)
         {
            s = new Scanner(new File("/home/alex/Java/src/Excercises2/mri/mri/" + i +".csv"));

            array2D = new ArrayList<ArrayList<Integer>>();

            while(s.hasNext()){
                tempString = s.nextLine().split(",");
                temparraylist = new ArrayList<Integer>();
                for (int j = 0; j < tempString.length; j++) {
                    temparraylist.add(Integer.parseInt(tempString[j]));
                }
                temp1 = temparraylist.size();
                array2D.add(temparraylist);
            }
            temp2 = array2D.size();
            array3D.add(array2D);
        }
        temp3 = array3D.size(); //this is redundant, but it makes the code easier to understand
        s.close();

        this.arrayOfMRI3D = new int[temp3][temp2][temp1];

        for (int k = 0; k < array3D.size(); k++) {
            for (int j = 0; j < array3D.get(k).size(); j++) {
                for (int i = 0; i < array3D.get(k).get(j).size(); i++) {
                    this.arrayOfMRI3D[k][j][i] = array3D.get(k).get(j).get(i);
                }
            }
        }


        //debug printing

        /*for (int i = 0; i < this.arrayOfMRI3D.length; i++) {
            for (int j = 0; j < this.arrayOfMRI3D[i].length; j++) {
                for (int k = 0; k < this.arrayOfMRI3D[i][j].length; k++) {
                    System.out.print(this.arrayOfMRI3D[i][j][k]);
                }
                System.out.println("/n");
            }
        }*/

    }


    public void readData2D() throws FileNotFoundException {

        int fileNumber = 151;

        ArrayList<ArrayList<Integer>> array2D = new ArrayList<ArrayList<Integer>>();
        String[] string = null;
        ArrayList<Integer> temp;
        int temp1 = 0;
        int temp2 = 0;

        //goal -> read in and fill in reverse the 2d array. i.e.: this.array[j][i]
        //1. dynamically read in the file and return a temp for how many rows there are
        //2. assign temp to rows
        //3. initalise and return the temp2 of number of columns
        //4. assign temp2 to columns
        //5. fille number of rows with columns

        //Scanner s = new Scanner(new File("/home/averagejoe/IdeaProjects/Java/Rocketman/src/Excercises2/mri/" + this.fileNumber +".csv"));
        //Scanner s = new Scanner(new File("/home/averagejoe/IdeaProjects/Java/Rocketman/src/Excercises2/mri/" + this.fileNumber , ".csv")); there is a comma between this.fileNumber , ".csv"
        //I am unaware what the difference is.

        Scanner s = new Scanner(new File("/home/averagejoe/IdeaProjects/Java/Rocketman/src/Excercises2/mri/" + fileNumber + "+.csv"));


        while(s.hasNext()){
            string = s.nextLine().split(",");
            temp = new ArrayList<Integer>();
            for (int i = 0; i < string.length; i++) {
                temp.add(Integer.parseInt(string[i]));
            }
            temp1 = temp.size();
            array2D.add(temp);
        }
        temp2 = array2D.size(); //is redundant, but makes code more readable
        s.close();

        //array2D.toArray(this.arrayOfMRI2D);

        this.arrayOfMRI2D = new int[temp2][temp1];

        for (int i = 0; i < array2D.size(); i++) {
            for (int j = 0; j < array2D.get(i).size(); j++) {
                    this.arrayOfMRI2D[j][i] = array2D.get(i).get(j);
            }
        }


        //debug print

        for (int l = 0; l < this.arrayOfMRI2D.length; l++) {
            for (int m = 0; m < this.arrayOfMRI2D[l].length; m++) {
                System.out.print(this.arrayOfMRI2D[l][m]);
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
