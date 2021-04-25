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

        getNationalityArray();
    }


    public List<String> getNationalityArray() {
        List<String> arr = new ArrayList<>();
        try {
            File f = new File("/home/averagejoe/IdeaProjects/Java/src/Assignment/nationalities.txt");
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
            arr.add(s.nextLine());
            }
            s.close();
        }
        catch (FileNotFoundException e){
            System.out.println("File not found | " + e.getMessage());
        }
        return arr;
    }

}