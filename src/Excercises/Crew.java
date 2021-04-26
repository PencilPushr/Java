package Excercises;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Crew extends Astronaut{

    private static final String[] RANKS = { "Commander", "Pilot", "Payload Commander", "Mission specialist", "Spaceflight Participant"};
    private static  String[] nationalities;
    private static List<Astronaut> crew = new ArrayList<>();
    public static String filepath = ("/home/averagejoe/IdeaProjects/Java/Rocketman/src/Excercises/nationalities.txt");
    ///home/alex/Java/src/Assignment/

    public Crew(String nationality, String rank, int rankNum, int age, String filepath) {
        super(nationality, rank, rankNum, age);
        this.filepath = filepath;
        String currentRank = RANKS[crew.get(0).getRankNum()];

        this.nationalities = getNationalityArray(filepath);

        for (int i = 0; i <= this.nationalities.length; i++){
            for (int j = 0; j < this.RANKS.length; j++) {
                Astronaut astronaut = new Astronaut(nationalities[i], RANKS[j], j, randomAge());
                crew.add(astronaut);
            }
        }
    }


    public static void main(String[] args) {

        /*
        for (int i = 0; i < getNationalityArray(filepath).length; i++) {
            String[] tmp = getNationalityArray(filepath);
            System.out.println(tmp[i].toString());
        }


         */
        nationalities = getNationalityArray(filepath);
        for (int i = 0; i < nationalities.length; i++){
            for (int j = 0; j < RANKS.length; j++) {
                Astronaut astronaut = new Astronaut(nationalities[i], RANKS[j], j, randomAge());
                crew.add(astronaut);
                System.out.println(astronaut);
            }
        }
    }


    public static String[] getNationalityArray(String filepath) {
        ArrayList<String> arr = new ArrayList<>();
        try {
            Scanner s = new Scanner(new File(filepath));
            while (s.hasNextLine()) {
                arr.add(s.nextLine());
            }
            s.close();
        }
        catch (FileNotFoundException e){
            System.out.println("File not found | " + e.getMessage());
            e.printStackTrace();
        }
        String[] items = arr.toArray(new String[arr.size()]);
        return items;
    }

    public static int randomAge() {
        int age = 0;
        age= (int) (Math.random() * (55 - 32 + 1));
        return age;
    }

    public void PrintCrew(){

    }


}