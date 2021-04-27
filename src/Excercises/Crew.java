package Excercises;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Crew extends Astronaut{

    // make these static for debug
    private static final String[] RANKS = { "Commander", "Pilot", "Payload Commander", "Mission specialist", "Spaceflight Participant"};
    private String[] nationalities;
    private List<Astronaut> crew = new ArrayList<>();
    public static String filepath = ("/home/alex/Java/src/Excercises/nationalities.txt");
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
        //System.out.println(assembleMissionCrew());
    }

/* -- debug
    public static void main(String[] args) {

/*        for (int i = 0; i < getNationalityArray(filepath).length; i++) {
            String[] tmp = getNationalityArray(filepath);
            System.out.println(tmp[i].toString());
        }


        nationalities = getNationalityArray(filepath);
        for (int i = 0; i < nationalities.length; i++){
            for (int j = 0; j < RANKS.length; j++) {
                Astronaut astronaut = new Astronaut(nationalities[i], RANKS[j], j, randomAge());
                crew.add(astronaut);
                System.out.println(astronaut);
            }
        }
    }

    */

    //make getNationality and randomAge static for debug
    //also not sure if it's even worth having a try catch block, if filepath is invalid in the first place
    public String[] getNationalityArray(String filepath) {
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

    public int randomAge() {
        int age = 0;
        age= 28 + (int) (Math.random() * (55 - 28 + 1));
        return age;
    }

    public void PrintCrew(){
        for (int i = 0; i < crew.size(); i++) {
            System.out.println(crew.get(i));
        }
    }

    public void sortCrew(){
        Collections.sort(crew);
    }

    public void shuffleCrew(){
        Collections.shuffle(crew);
    }

   /* public Map<String, Astronaut> assembleMissionCrew(){
        //Set<>
        //        Random rng = new Random();
        Set<String> = RANKS;
        Map<String, Astronaut> missionCrew = new TreeMap<>();
        missionCrew.put(RANKS, );
    }*/

//    public static Set<String> randomSelector(){
//    }

}