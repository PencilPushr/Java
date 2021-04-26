package Excercises;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Crew extends Astronaut{

    private static final String[] RANKS = { "Commander", "Pilot", "Payload Commander", "Mission specialist", "Spaceflight Participant"};
    private String[] nationalities;
    private List<Astronaut> crew = new ArrayList<>();
    public static String filepath = ("/home/alex/Java/src/Assignment/nationalities.txt");
    ///home/alex/Java/src/Assignment/

    public Crew(String nationality, String rank, int rankNum, int age, String filepath) {
        super(nationality, rank, rankNum, age);
        this.filepath = filepath;

        String currentRank = RANKS[crew.get(0).getRankNum()];


    }

    public static void main(String[] args) {

        for (int i = 0; i < Crew.getNationalityArray(filepath).length; i++) {
            System.out.println(Crew.getNationalityArray(filepath).toString());
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

    @Override
    public String toString() {
        return String.format()
    }
}