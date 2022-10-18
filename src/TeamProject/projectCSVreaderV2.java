package TeamProject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class projectCSVreaderV2 {

    public class student{

        //public int id;
        public int course;
        //TODO: make modules and results a hashmap; each module, has a result and therefore is a pair.
        public String[] modules;
        public int[] moduleResults;

    }

    private HashMap<Integer, projectCSVreaderV2.student> studentDet;

    projectCSVreaderV2() throws FileNotFoundException {

        String fileName = "data.csv";
        Scanner s = new Scanner(new FileReader(fileName));
// if the first line is the header

        String[] header = s.nextLine().split(",");
        boolean first = true;

        while(s.hasNext()) {
            String thing = s.nextLine();
            if (first == false) {
                String[] line = thing.spl
            }
            first = false;
        }

    }

}
