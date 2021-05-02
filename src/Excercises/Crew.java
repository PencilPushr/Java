package Excercises;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Crew{

    // make these static for debug
    private static final String[] RANKS = { "Commander", "Pilot", "Payload Commander", "Mission specialist", "Spaceflight Participant"};
    private String[] nationalities;
    private ArrayList<Astronaut> crew = new ArrayList<Astronaut>();
    public String filepath;// = ("/home/alex/Java/src/Excercises/nationalities.txt"); this is an example of what it could be.
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

    public Astronaut getAstronautOfRank(String rank){
        List valid = Arrays.asList(this.RANKS); //Create a list to validate the rank we are checking
        if (valid.contains(rank)){ // if the list valid contains the inputted string shuffle (fair chance at selection)
            Collections.shuffle(crew);
            for (int i = 0; i < this.crew.size(); i++){ //iterating through the crew list of Astronauts
                if (this.crew.get(i).getRank().equals(rank)){ // if the Astronaut of RANK x is equal to the String rank
                    return this.crew.get(i); //return the Astronaut.
                }
            }
            System.out.println("There is no Astronaut of this rank | Error"); //this has been called before there are astronauts in the list.
            System.exit(0);
        } else {
            System.out.println("Attempted to retrieve Astronaut of an invalid rank | Error"); // Error: the string rank is out of bounds.
            System.exit(0);
        }
        //This shouldn't ever happen, be concerned if it does.
        return null;
    }

    public Map<String, Astronaut> assembleMissionCrew(){
        Set<String> rank = new HashSet<>(Arrays.asList(this.RANKS)); //Creating a set
        HashMap<String, Astronaut> missionCrew = new HashMap<String, Astronaut>(); //
        for (int i = 0; i < this.RANKS.length; i++) {
            missionCrew.put(this.RANKS[i], this.getAstronautOfRank(this.RANKS[i]));
        }
        return missionCrew;
    }

}