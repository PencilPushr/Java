package Euler.P18;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class p18 {

    public static String filepath = "/home/alex/Java/src/Euler/P18/Triangle.txt";

    public static void main(String[] args){
        p18 main = new p18();

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j <= i; j++){
                //System.out.print(readinFile()[i][j] + " ");
            }
            //System.out.println("");
        }
        algorithm();
    }

    public static void algorithm() {

        Integer[][] copy = readinFile();

       for (int i = copy.length -2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                copy[i][j] = (copy[i][j]) + (Math.max((copy[i+1][j]), (copy[i+1][j+1])));
            }
           System.out.println(copy[i]);
       }
        System.out.println(copy[0][0]);
/*
        for (int k = 0; k < readinFile().length - 1; k++) {
            int i = readinFile().length - k - 1;
            for
        }*/
    }

    public static Integer[][] readinFile(){
        ArrayList<Integer> arrL = new ArrayList<>();
        Scanner s = null;
        try {
            s = new Scanner(new File(filepath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (true) {
            assert s != null;
            if (!s.hasNextInt()) break;
            arrL.add(s.nextInt());
        }
        s.close();

        //120 for 18
        //5050 for euler 67
        int rows = (int) (Math.sqrt((8 * 120) + 1) - 1) / 2;

        Integer[][] Tri = new Integer[rows][rows];

        for (int i = 0; i < rows; i++) {
            int Ti = ((i + 1) * i) / 2;
            for (int j = 0; j <= i; j++) {
                Tri[i][j] = arrL.get(Ti + j);
            }
        }
        //String[] ezArray = arrL.toArray(new String[arrL.size()]);
        return Tri;
    }
}