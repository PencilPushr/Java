package Excercises;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class MainCrew {

    public static void main(String[] args) {
        MainCrew mainCrew = new MainCrew();
        mainCrew.menu();

    }

    public void menu(){
        boolean stop = false;

        System.out.println("\nMenu Options\n");
        System.out.println("(1) - print crew (sorted)");
        System.out.println("(2) - print crew (shuffled)");
        System.out.println("(3) - to assemble and print mission crew");
        System.out.println("quit - quit");

        System.out.println("\nPlease enter selection: \n");

        while (!stop) {
            try {
                Scanner s = new Scanner(System.in);
                String input;

                System.out.println(" 1 - print crew (sorted)");
                System.out.println(" 2 - print crew (shuffled)");
                System.out.println(" 3 - to assemble and print mission crew");
                System.out.println("quit - quit");

                System.out.println("Would you like to quit?");
                input = s.next().toLowerCase();
                if (input.equals("quit")) {
                    stop = true;
                }
            }
            catch (InputMismatchException e){
                System.out.println("Illegal input | " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
