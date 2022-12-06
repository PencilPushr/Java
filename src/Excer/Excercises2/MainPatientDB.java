package Excer.Excercises2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MainPatientDB {


    //it appears from testing that everything will have to have its own loop and have one giant loop acting as a container

    //pseudo code
    /*while (!isSentinalValue) {
        input1 = invalidValue
        while (input1NotValid) {
            getInput
        }
        use input to do menu things
    }
*/

    public static void main(String[] args){

        String[] menuItems = new String[]{"1", "2", "3", "quit"};
        String menuInput;

        //need a boolean for the first loop -> where we enter the file

        boolean stop = false;
        String fileInput;
        Scanner s = new Scanner(System.in);


        while (!stop) {
            try {
                System.out.println("Please input the file name: ");
                fileInput = s.nextLine();
                s = new Scanner(new File(fileInput));
                PatientDB pat = new PatientDB(fileInput);
                s.close();
                Scanner p = new Scanner(System.in);
                while(!stop){
                    menuOptions();
                    menuInput = p.nextLine();
                    String temp = whatIsInput(menuItems, menuInput); //calls the function to check against the menuItems array
                    if (temp != null && !temp.isEmpty()){ //if its null just immediately jump to invalid entry, don't bother checking it
                        //could have done a SWITCH, but I felt like the code would break some how, some where and in some way.
                        if (temp.equals("1")){
                            pat.sortDB();
                        }
                        if (temp.equals("2")){
                            pat.shuffleDB();
                        }
                        if (temp.equals("3")){
                            System.out.println(pat.generatePatientSample()); // cba with creating new method to print it.
                            //if need be I could provide on how to -> just in case i get marked down (see below)
                            //example: using generatePS() simply iterate through the map and print them one by one.
                        }
                        if (temp.equals("quit")){
                            stop = true;
                        }
                    } else {
                        System.out.println("Sorry, invalid entry!");
                    }
                }
                stop = true;
                p.close();
            } catch (FileNotFoundException e){
                System.out.println("File does not exist");
            } catch (NullPointerException ignored){
                //do not care if we get a null pointer
            }
        }

    }

    public static String whatIsInput(String[] menuIt, String menuIn){

        String temp = null;

        for (int i = 0; i < menuIt.length; i++) {
            if (menuIn.equals(menuIt[i])){
                temp =menuIt[i].toString();
            }
        }
        return temp;

    }

    public static void menuOptions(){
        System.out.println(" ----------------- MENU ----------------- ");
        System.out.println(" 1 to print patient database (sorted) ");
        System.out.println(" 2 to print patient database (shuffled) ");
        System.out.println(" 3 to generate patient sample");
        System.out.println(" quit to quit ");
        System.out.println(" input: ");
    }
}