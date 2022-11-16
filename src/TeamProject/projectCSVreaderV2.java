package TeamProject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class projectCSVreaderV2 {

    private Pattern pattern;

    public class student{

        private int course;
        private HashMap<String, Integer> moduleAndResults;
        //TODO: make it so person will only have module if they have a result in the CSV
        // consider removing the module if the result is null.
        // TEMP FIX: set int to -1 if they don't have the module


    }

    private HashMap<Integer, projectCSVreaderV2.student> studentDetails;

    projectCSVreaderV2() throws FileNotFoundException {

        String fileName = "data.csv";
        Scanner s = new Scanner(new FileReader(fileName));

        this.pattern = Pattern.compile("[(a-zA-Z0-9)+\\s+]+(,)?");
        //some values in the CSV file are null -> ",,,44,32,,27"
        //if the pattern does not apply, we skip the value and apply null when inputting it the Hashmap
        //or remove that string from the persons hashmap.

        String[] header = s.nextLine().split(",");
        boolean matches = true;

        while(s.hasNext()) {
            String[] line = s.nextLine().split(this.pattern.pattern());

        }


    }

    private boolean regexValuethenCommaCheck(String s){
        return this.pattern.matcher(s).find();
    }

}
