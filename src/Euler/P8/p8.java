package Euler.P8;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class p8 {

    public p8(){
        readInFile();
    }

    public static void main(String[] args) {
        new p8();
    }

    public void readInFile(){

        int sizeOfArray = 0;
        String directory = System.getProperty("user.dir") + "/src/Euler/P8/square";
        Scanner s = new Scanner(directory);

        while(s.hasNext()){
            sizeOfArray++;
        }
    }

}
