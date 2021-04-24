package Assignment;

import java.util.ArrayList;
import java.util.List;

public class Crew extends Astronaut{

    private static final String[] RANKS = { "Commander", "Pilot", "Payload Commander", "Mission specialist", "Spaceflight Participant"};
    private String[] nationalities;
    private List<Astronaut> crew = new ArrayList<>();

    public Crew(String nationality, String rank, int rankNum, int age) {
        super(nationality, rank, rankNum, age);

    }

    //RANKS[crew.get(0).getRank()];
}