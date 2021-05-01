package Excercises;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class MainCrew {

    private Crew crew;

    public static void main(String[] args) {
        MainCrew mainCrew = new MainCrew();
        mainCrew.menu();

    }

    public String askFile(){
        boolean stop = false;

        while (!stop){
            try {
                Scanner s = new Scanner(System.in);
                String input;

                System.out.println("Input the name of the file to read nationalities");

                input = s.next().toLowerCase();
            }
            catch {

            }
        }

    }

    public void menu(){
        MainCrew mainCrew = new MainCrew();
        String file = mainCrew.askFile();
        this.crew = new Crew(file);

        boolean stop = false;

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
                //check if input is valid
                //switch: check if 
                //switch: have a default for case that is not recongised

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
