package Assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Crew extends Astronaut{

    private static final String[] RANKS = { "Commander", "Pilot", "Payload Commander", "Mission specialist", "Spaceflight Participant"};
    private String[] nationalities;
    private List<Astronaut> crew = new ArrayList<>();

    public Crew(String nationality, String rank, int rankNum, int age) {
        super(nationality, rank, rankNum, age);

        String currentRank = RANKS[crew.get(0).getRankNum()];
    }

    public static List<String> nationalityArr() {
        List<String> arr = new ArrayList<>();
        try {
            File f = new File("Assignment/nationalities.txt");
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {

            }
        }
        catch (FileNotFoundException e){
            System.out.printf("File not found | " + e.getMessage());
        }
        return arr;
    }

}