package Exercises3.ex3;

import java.io.FileNotFoundException;

public class PopulationDisplay {

    public PopulationDisplay(String filename){
        try {
            PopulationData popData = new PopulationData(filename);
        }catch (FileNotFoundException e){
            System.out.println("File not found");
            e.printStackTrace();
        }
    }
}
