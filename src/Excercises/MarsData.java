package Excercises;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class MarsData extends Plot{

    private double[][] arrayOfMars;

    public String[] CSVReader(){
        ArrayList<String> arr = new ArrayList<>();
        String line = "";
        String splitBy = ",";
        try {//parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(new FileReader("CSVDemo.csv"));
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] employee = line.split(splitBy);    // use comma as separator
        }
        catch (FileNotFoundException e){
            System.out.println("File not found | " + filepath);
            e.printStackTrace();
        }
    }
}
