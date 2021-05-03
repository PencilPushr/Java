package Excercises;

import javax.naming.directory.InvalidSearchFilterException;
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
            catch (InvalidSearchFilterException e){
                System.out.println("")
            }
            try {

            } catch (){

            }
        }

    }

    public void menu(){
        MainCrew mainCrew = new MainCrew();
        //String file = mainCrew.askFile();
        //this.crew = new Crew(file);

        boolean stop = false;

        while (!stop) {
            try {
                Scanner s = new Scanner(System.in);
                String input;

                System.out.println(" 1 - print crew (sorted)");
                System.out.println(" 2 - print crew (shuffled)");
                System.out.println(" 3 - to assemble and print mission crew");
                System.out.println("quit - quit");

                input = s.next().toLowerCase();
                //check if input is valid
                //switch: have a default for case that is not recognised

                switch (input.toLowerCase()) {
                    case "1":
                        crew.sortCrew();
                        crew.PrintCrew();
                        break;

                    case "2":
                        crew.shuffleCrew();
                        crew.PrintCrew();
                        break;

                    case "3" :
                        crew.assembleMissionCrew();
                        crew.PrintCrew();
                        break;

                    case "quit" :
                        stop = true;
                        break;

                    default:
                        System.out.println("Invalid menu options entered!");
                        menu();
                }
            }
            catch (InputMismatchException e){
                System.out.println("Illegal input | Error = " + e.getMessage());
                e.printStackTrace();
            }
            catch (NullPointerException e){
                System.out.println("Crew has not been populated | Error = " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
