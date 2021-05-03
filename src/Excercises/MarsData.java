package Excercises;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MarsData {

    private double[][] arrayOfMars;
    public static String filepath;

    public static void main(String[] args) {
        CSVReader();
    }

    public static Double[][] CSVReader(){
        /*ArrayList<String> arr = new ArrayList<>();
        String line = "";
        String splitBy = ",";
        try {//parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(new File("CSVDemo.csv"));
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] employee = line.split(splitBy);    // use comma as separator
            }
        }
        catch (FileNotFoundException e){
            System.out.println("File not found | " + filepath);
            e.printStackTrace();
        }*/
        ArrayList<String> arr = new ArrayList<>();

        String  lineSplit[] = new String[3];

        try {
            Scanner s = new Scanner(new File(filepath));
            String line = s.nextLine();

            while (s.hasNextLine()) {
                lineSplit[0] = line;
                lineSplit[1] = line.split(",")[1];
                lineSplit[1] = line.split(",")[2];
                lineSplit[1] = line.split(",")[3];
            }

            System.out.println(Arrays.toString(lineSplit));

            s.close();
        }

        catch (FileNotFoundException e){
            System.out.println("File not found | " + filepath);
            e.printStackTrace();
        }
        Double[][] items = arr.toArray(new Double[arr.size()][arr.size()]);
        return items;
    }
}
