package Labs.Lab9.labexercise3;

import java.util.regex.Pattern;

public class MyInputInfo implements Comparable{ //is meant to hold only one key press, Hashmap will hold multiple of these

    private boolean boolInt;
    private String content; //can act as both an int, or a string/char
    private Pattern pattern;

    MyInputInfo(String input){ //we know input has to be a string
        this.pattern = Pattern.compile("[0-9]+(\\.[0-9]+)?"); //regex101.com
        // REGEX: "[0-9]+(\.[0-9]+)?"
        // [0-9] regex for numbers 0-9 (alt: \d for digits)
        // + implies one or more cases of [0-9]
        // ()? at most one of the pattern inside the brackets
        // \. is a decimal
        // this will match any integer and potential double we encounter

        //the double slash is needed because java has \ as an escape character, we need to escape the escape char

        if (input.equals("")){ //check there are no empty inputs
            System.out.print("No Empty inputs.");
            System.exit(1);
        } else if (regexIntDoubleCheck(input)){ //check if it's an integer or a double
            this.boolInt = true;
            this.content = input;
        } else { //must be a char/string
            this.content = input.substring(0, 1);
        }

    }

    @Override
    public int compareTo(Object o) {
        // First case, they are the same.
        if (this.toString().equals(o.toString())) return 0;

        //they must not be the same if it made it this far
        int result = this.toString().compareTo(o.toString()); //on the JAVA ASCII table, ints appear before upper and lower case alphabet symbols

        /* in case the above compareTo method is disqualified
        int l1 = str1.length();
        int l2 = str2.length();
        int lmin = Math.min(l1, l2);

        for (int i = 0; i < lmin; i++) {
            int str1_ch = (int)str1.charAt(i); //corresponding ascii char (why str1_ch is an int)
            int str2_ch = (int)str2.charAt(i);

            if (str1_ch != str2_ch) {   //check if the char at index i is the same.
                return str1_ch - str2_ch;
            }
        }
        if (l1 != l2) { //prevents cases where they might contain the same initial string pattern
            return l1 - l2;
        }

        // If none of the above conditions is true,
        // it implies both the strings are equal
        else {
            return 0;
        }

         */

        if (this.toString().equals(o.toString())) return 0;

        //if a1 > a2, it returns negative number
        //if a1 < a2, it returns positive number
        //if a1 == a2, it returns 0

        return result;
    }


    @Override
    public String toString() {
        if (boolInt){ //check if it's an int/double
            return "Numeric" + this.content;
        }
        return "Symbol" + this.content; //else must be a char
    }

    //most efficient solution
    private boolean regexIntDoubleCheck(String s){
        return this.pattern.matcher(s).find();
    }

    public String getContent() {
        return content;
    }

    public boolean isBoolInt() {
        return boolInt;
    }




    //Code block is obsolete because of regexIntDoubleCheck()

    /*
    private boolean isDouble(String s){
        try {
            Double.parseDouble(s);
            //boolDouble = true;
            boolInt = false;
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }

    private boolean isInt(String s)
    {
        try {
            Integer.parseInt(s);
            this.boolInt = true;
            //boolDouble = false;
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    //Checks and builds the number to put into content, works for INT and DOUBLE
    private String buildNumber(String str) {
        StringBuilder strBuilder = new StringBuilder();
        //maybe use substring to then place them at strbuilder?
        //str.substring(0,i) == "."
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(Character.isDigit(ch) || str.contains(".")) // if it is a digit, or it has a decimal
                strBuilder.append(ch);
        }
        //don't need to return anything else, we will return an empty string if its not a number
        return strBuilder.toString();


    }
    */
}