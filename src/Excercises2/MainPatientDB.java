package Excercises2;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainPatientDB {


    //it appears from testing that unfortunately everything will have to have its own loop and have one giant loop acting as a container,
    //I don't know why, but for the life of me I could not figure out why everytime an input for exit was entered it had to be entered twice
    //and even more fucking infuriating was the more options that were are selected the more the code broke down

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
        //MainPatientDB mainp = new MainPatientDB();

        //need a boolean for the first loop -> where we enter the file

        boolean stop = false;

        while (!stop) {
            try {
                String a = getTextFile();

            } catch
        }

    }

    public static void menu() throws FileNotFoundException {

        //Scanner s = new Scanner(System.in);

    }


    public String isInputValid(String s) {

        if () {
        }


        return string;
    }


    public static void menuOptions(){
        System.out.println(" ----------------- MENU ----------------- ");
        System.out.println(" 1 to print patient database (sorted) ");
        System.out.println(" 2 to print patient database (shuffled) ");
        System.out.println(" 3 to generate patient sample");
        System.out.println(" quit to quit ");
        System.out.println(" input: ");
    }

    public static String getTextFile(){
        System.out.println("Please input the file name: ");
        Scanner s = new Scanner(System.in);
        String fileInput = s.nextLine();

        return fileInput;
    }
}