package Excercises2;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainPatientDB {

    //pseudo code
    /*while (!isSentinalValue) {
        input = invalidValue
        while (inputNotValid) {
            getInput
        }
        use input to do menu things
    }
*/


    public static void main(String[] args) {
        MainPatientDB mainp = new MainPatientDB();

        while ()

            try {
                mainp.menu();
            } catch (FileNotFoundException e) {
                System.out.println("File could not be found | Error = " + e.getMessage());
            }
    }

    public void menu() throws FileNotFoundException {

        System.out.println("Enter the file path location, including the file name containing the nationalities: ");
        Scanner s = new Scanner(System.in);

        boolean stop = false;

        while (!stop) {
            try {

            }
        }
    }
}