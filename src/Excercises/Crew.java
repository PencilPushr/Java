package Excercises;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Crew{

    // make these static for debug
    private static final String[] RANKS = { "Commander", "Pilot", "Payload Commander", "Mission specialist", "Spaceflight Participant"};
    private String[] nationalities;
    private ArrayList<Astronaut> crew = new ArrayList<Astronaut>();
    public static String filepath = ("/home/alex/Java/src/Excercises/nationalities.txt");
    ///home/alex/Java/src/Assignment/

    public Crew(String filepath) {
        this.filepath = filepath;

        this.nationalities = getNationalityArray(filepath);

        for (int i = 0; i <= this.nationalities.length; i++){
            for (int j = 0; j < this.RANKS.length; j++) {
                Astronaut astronaut = new Astronaut(this.nationalities[i], this.RANKS[j], j, randomAge());
                crew.add(astronaut);
            }
        }
        //System.out.println(assembleMissionCrew());
    }

    //make getNationality and randomAge static for debug
    //also not sure if it's even worth having a try catch block, if filepath is invalid in the first place
    public String[] getNationalityArray(String filepath){
        ArrayList<String> arr = new ArrayList<>();
        try {
            Scanner s = new Scanner(new File(filepath));
            while (s.hasNextLine()) {
                arr.add(s.nextLine());
            }
            s.close();
        }
        catch (FileNotFoundException e){
            System.out.println("File not found | " + filepath);
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

    public Map<String, Astronaut> assembleMissionCrew(){
        Set<String> rank = new HashSet<>(Arrays.asList(this.RANKS));
        HashMap<String, Astronaut> missionCrew = new HashMap<String, Astronaut>();
        for (int i = 0; i < this.RANKS.length; i++) {
            missionCrew.put(this.RANKS[i], ); //Need to create a method of getting astronaut of certain rank (NameofRank,
        }
    }

//    public static Set<String> randomSelector(){
//    }

}