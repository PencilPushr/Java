package Euler.P4;

public class p4 {


    public static void main(String[] args) {
        p4 project = new p4();
        int biggestPalindrome = 0;

        //Enter two loops checking every 3 digit number
        //we check every inner loop if the number is a palindrome, if it is, add it to counter
        //check the current biggest palindrome to counter, if counter is bigger, replace it.
        for (int i = 100; i <= 999; i++) {
            for (int j = 100; j <= 999; j++) {
                if (project.isPalindrome(i * j)) {
                    int counter = i*j;
                    if (counter >= biggestPalindrome){
                        biggestPalindrome = counter;
                    }
                }
            }
        }
        //final palindrome that we use
        System.out.println(biggestPalindrome);
    }

    boolean isPalindrome(Integer x) {
        String y = x.toString();

        for (int i = 0; i <= y.length()/ 2; i++) {
            if (y.charAt(i) != y.charAt(y.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}