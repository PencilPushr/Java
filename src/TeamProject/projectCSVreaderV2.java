package TeamProject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class projectCSVreaderV2 {

    projectCSVreaderV2() throws FileNotFoundException {

        String fileName = "data.csv";
        Scanner s = new Scanner(new FileReader(fileName));
// if the first line is the header

        String[] header = s.nextLine().split(",");

        while(s.hasNext()) {
            String thing = s.nextLine();
            if (first == false)
                String[] line = thing.spl
        }

    }

}
