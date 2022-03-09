package Labs.Lab9.labexercise3;

import java.util.Scanner;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;

public class MyKeyboardInput {

    //private

    public static void main(String[] args) {
        System.out.print("THIS IS A TEST");
        HashMap<MyInputInfo, Integer> keyPressed = new HashMap<MyInputInfo, Integer>();
        Set<String> allKeys = new HashSet<String>();

        Scanner s = new Scanner(System.in);
        String a = s.nextLine();
        String[] b = a.split("\\s+"); // using a whitespace delimiter with + implies the use of multiple whitespace characters
        s.close();


    }

}

