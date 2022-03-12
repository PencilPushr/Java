package Labs.Lab9.labexercise3;

import java.util.*;

public class MyKeyboardInput {

    //private

    public static void main(String[] args) {

        Set<String> allKeys = new HashSet<String>();
        HashMap<MyInputInfo, Integer> keyPressed = new HashMap<MyInputInfo, Integer>();

        Scanner s = new Scanner(System.in);
        String a = s.nextLine();
        s.close(); // close scanner after we have finished reading input

        String[] b = a.split("\\s+"); // using a whitespace delimiter with + implies the use of multiple whitespace characters
        allKeys.addAll(Arrays.asList(b));// bulk add the entire string array to the set



    }

}

