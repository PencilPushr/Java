package Exercises3.ex2;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class Main {
    final static String[] menuItems = new String[]{"1", "2", "3", "4", "quit"};
    final static String menuOpts = " ----------------- MENU ----------------- \n 1 to print 10 largest cities \n 2 to print 10 smallest cities \n 3 to enter a country and print cities from this country \n 4 to enter a latitude and longitude and print 10 closest cities \n quit to quit \n  input: \n";

    public static void main(String[] args) {

        // First, we define useful variables.
        boolean stop = false;
        String fileInput = null;
        java.util.Scanner p = new java.util.Scanner(System.in);
        String menuInput = "";

        CityData city = null;

        //Now we try to get a valid file
        while (!stop) {
            try {
                System.out.println("Please input the file name: ");
                fileInput = p.nextLine();
                city = new CityData(fileInput);
                stop = true;
            } catch (FileNotFoundException e){
                System.out.println("File does not exist, please try again.");
            } catch (NullPointerException ignored){
                System.out.println("Null Pointer Issue");
            }
        }
        stop = false;

        //Now we execute user commands, until the user is finished.
        while(!stop){
            System.out.print(menuOpts);
            assert city != null;
            switch (p.nextLine()){
                case "1":
                    city.printLargest10();
                    break;
                case "2":
                    city.printSmallest10();
                    break;
                case "3":
                    System.out.println("Enter country name: ");
                    city.printCountry(p.nextLine());
                    break;
                case "4":
                    Double.parseDouble(p.nextLine());
                    city.printClosest10();
                    break;
                case "quit":
                    stop = true;
                    break;
                default:
                    System.out.print("Sorry, that isn't a valid input.\n");
            }
        }
        p.close();

    }

}