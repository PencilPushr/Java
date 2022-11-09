package DSAA.Labs;


public class IntList {
    private int value;
    private IntList tail;

    /*******************************************************************
     * a) Fill in the methods that define the datatype.
     ******************************************************************/
    public IntList (int i) {
        this.value = i;
        this.tail = this.tail();
    }

    public IntList cons (int i) {
        // TODO: complete the cons method
        return null;
    }

    public int head() {
        // TODO: complete the head method
        return -1; // You'll need to change the return value
    }

    public IntList tail () {
        // TODO: complete the tail method
        return null; // You'll need to change the return value
    }

    /*******************************************************************
     * b) Write a method to produce the list 1, ..., n.
     ******************************************************************/
    public static IntList oneToN (int n) {
        // TODO: complete the oneToN method
        return null; // You'll need to change the return value
    }

    /*******************************************************************
     * c) Write a recursive method to calculate a list's length
     ******************************************************************/
    public int length () {
        // TODO: complete the length method
        return -1; // You'll need to change the return value
    }

    /*******************************************************************
     * d) Write a recursive method to check if a list contains i
     ******************************************************************/
    public boolean contains (int i) {
        // TODO: complete the contains method
        return false; // You'll need to change the return value
    }

    /*******************************************************************
     * e) Write a recursive method to total a list
     ******************************************************************/
    public int sum () {
        // TODO: complete the sum method
        return -1; // You'll need to change the return value
    }

    /*******************************************************************
     * f) Write a recursive method that returns a list containing the
     *    first, third, fifth, etc. values of this list.
     ******************************************************************/
    public IntList everyOtherValue () {
        // TODO: complete the everyOtherValue method
        return null; // You'll need to change the return value
    }

    /*******************************************************************
     * g) Same thing, but the second, fourth, sixth, etc.
     ******************************************************************/
    public IntList otherEveryOtherValue () {
        // TODO: complete the otherEveryOtherValue method
        return null; // You'll need to change the return value
    }

    /*******************************************************************
     * h) Write a recursive method that returns a list of all the even
     *    numbers in the current list
     ******************************************************************/
    public IntList evenValues () {
        // TODO: complete the evenValues method
        return null; // You'll need to change the return value
    }

    /*******************************************************************
     * i) Write a recursive method to reverse a list
     ******************************************************************/
    public IntList reverse () {
        // TODO: complete the reverse method
        return null; // You'll need to change the return value
    }

    /*******************************************************************
     * Utility methods. Please don't change.
     ******************************************************************/
    public String toString () {
        String s = Integer.toString (value); // convert to String
        if (tail == null)
            return s;
        else
            return s + "," + tail.toString();
    }

    public void printItem () {
        System.out.println (value + " " + tail);
    }

}
