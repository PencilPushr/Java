package TeamProject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class projectCSVreaderV2 {

    private Pattern pattern;

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

        this.pattern = Pattern.compile("[(a-zA-Z0-9)+\\s+]+(,)?");
        //some of the values in the CSV file are null -> ",,,44,32,,27"
        //if the pattern does not apply, we skip the value and apply null when inputting it the Hashmap
        //or place the string saying that they do not attend this module.

        String[] header = s.nextLine().split(",");
        boolean first = true;
        boolean matches = true;

        while(s.hasNext()) {
            String thing = s.nextLine();
            if (first == false) {
                 //String[] line = thing.spl
                String[] line = thing.split(this.pattern.pattern());
            }
            first = false;
        }

    }

    private boolean regexValuethenCommaCheck(String s){
        return this.pattern.matcher(s).find();
    }

}
