package Euler.P18;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class p18 {

    public static String filepath = "/home/alex/Java/src/Euler/P18/p067_triangle.txt";

    public static void main(String[] args) {
        p18 main = new p18();

        try {
            //for (int i = 0; i < main.readinFile().length; i++){
                System.out.println(Arrays.toString(main.readinFile()));
           // }
        }catch (FileNotFoundException e){
            System.out.println("File could not be found | Error = " + e.getMessage());
            e.printStackTrace();
        }catch (NoSuchElementException f){
            System.out.println("Incorrect Element selection switch to NEXTINT()" + f.getMessage());
            f.printStackTrace();
        }
    }



    public Integer[][] readinFile() throws FileNotFoundException, NoSuchElementException {
        ArrayList<Integer> arrL = new ArrayList<>();
        Scanner s = new Scanner(new File(filepath));
        int c = 1; // incremented number to use as filler

        while(s.hasNextInt()){
            arrL.add(s.nextInt());
        }
        s.close();

        int rows = (int) (Math.sqrt((8 * 5050) + 1) -1)/2;
        int columns = rows;

        Integer[][] Tri = new Integer[100][100];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= i; j++) {
                Tri[i][j] = c;
                c++;
            }
            Tri[i] = new Integer[i+1];

        }
        //String[] ezArray = arrL.toArray(new String[arrL.size()]);
        return Tri;
    }

    public int arraysize() throws FileNotFoundException {
        ArrayList<Integer> arrL = new ArrayList<>();
        Scanner s = new Scanner(new File(filepath));

        while(s.hasNextInt()){
            arrL.add(s.nextInt());
        }
        s.close();

        int abra = arrL.size();
        return abra;
    }
/*
    private ArrayList<Integer> getIntegerArray(ArrayList<String> stringArray) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(String stringValue : stringArray) {
            try {
                //Convert String to Integer, and store it into integer array list.
                result.add(Integer.parseInt(stringValue));
            } catch(NumberFormatException nfe) {
                //System.out.println("Could not parse " + nfe);
                Log.w("NumberFormat", "Parsing failed! " + stringValue + " can not be an integer");
            }
        }
        return result;
    }*/
}
