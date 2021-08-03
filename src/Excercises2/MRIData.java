package Excercises2;

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
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

    }

    public static void readData2D() throws FileNotFoundException {

        TwoDimentionalArrayList tdal = new TwoDimentionalArrayList();
        List<List<String>> al = new ArrayList<List<String>>();
        String temp = null;


        Scanner s = new Scanner(new File("/home/alex/Java/src/Excercises2/mri/mri/151.csv"));
        s.useDelimiter(",");

        while(s.hasNextLine()){
            temp = s.next();
            al.get(i).add(temp);
        }

        System.out.println(Arrays.toString(al.toArray()));


    }

    public int getIntensity2D(int coordinates){
        int temp = 0;

        return temp;
    }

}
