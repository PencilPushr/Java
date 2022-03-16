package Labs.Lab9.labexercise3;

import java.util.*;

public class MyKeyboardInput {

    //private

    public static void main(String[] args) {

        Set<String> allKeys = new HashSet<String>();
        Map<MyInputInfo, Integer> keyPressed = new TreeMap<MyInputInfo, Integer>();

        Scanner s = new Scanner(System.in);
        String a = s.nextLine();
        s.close(); // close scanner after we have finished reading input

        String[] b = a.split("\\s+"); // using a whitespace delimiter with + implies the use of multiple whitespace characters
        allKeys.addAll(Arrays.asList(b));// bulk add the entire string array to the set

        MyInputInfo[] myInputarray = new MyInputInfo[b.length];

        for (int i = 0; i < b.length; i++) {
            MyInputInfo myInputInfo = new MyInputInfo(b[i]);
            myInputarray[i] = myInputInfo;
        }


        for (int i = 0; i < myInputarray.length; i++) {

            keyPressed.merge(myInputarray[i], 1, Integer::sum);
            // map.merge(key, msg, String::concat) v read below for more info
            // https://docs.oracle.com/javase/8/docs/api/java/util/Map.html#merge-K-V-java.util.function.BiFunction-
            // https://stackoverflow.com/questions/20001427/double-colon-operator-in-java-8

            /*
            int count = keyPressed.getOrDefault(myInputarray[i], 0);
            keyPressed.put(myInputarray[i], count + 1);

            if (count == null) {
                keyPressed.put(myInputarray[i], 1);
            }else {
                keyPressed.put(myInputarray[i], count + 1);
            }

             */

        }


        System.out.println(allKeys); // prints the set

        //var appears to work like "auto" in C++
        for (var entry : keyPressed.entrySet()) { // prints the map as we can normally iterate through a map according to halder
            System.out.println(entry.getKey().toString() + "=" + entry.getValue());
        }

    }

}

