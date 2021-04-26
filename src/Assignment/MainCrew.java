package Assignment;

import java.util.Scanner;

public class MainCrew {

    public static void main(String[] args) {
        MainCrew mainCrew = new MainCrew();

        mainCrew.menu();
    }
    public void menu(){
        Scanner s = new Scanner(System.in);
        String q = "quit";

        while (true || q != "quit") {
            System.out.println("\nMenu Options\n");
            System.out.println("(1) - print crew (sorted)");
            System.out.println("(2) - print crew (shuffled)");
            System.out.println("(3) - to assemble and print mission crew");
            System.out.println("quit - quit");

            System.out.println("Please enter selection");

            String selection = s.next();

            switch (selection){

            }
        }
    }
}
