package DSAA.Labs;

import java.util.*;

/**
 *  A class implementing the stack ADT to provide a stack of strings. This
 *  implementation stores the data in an array, which initially has length
 *  10 and which is doubled every time the stack fills up.
 */
public class Stack {
    /*
     *  The entries of the stack and the number of items currently in the
     *  stack. Note that the fields are private, so the stack can only be
     *  accessed through the methods of the public interface. This prevents
     *  users from corrupting the data structure.
     */
    private String[] entries = new String[10];
    private int size = 0;

    /**
     *  push adds a string to the top of the stack.
     */
    public void push (String s) {
        /*
         *  Java arrays are indexed from zero so, if there are, e.g., five
         *  strings on the stack, they will be in positions 0-4. The next
         *  string to be added will go in position 5 and then the size will
         *  be 6.
         */
        entries[size] = s;
        size++;

        /*
         *  If the array is now full, we grow it so the next call to push()
         *  won't fail with an ArrayIndexOutOfBoundsException. We grow the
         *  array by doubling its length -- specifically, by making a new
         *  array that's twice as long, copying across the entries and then
         *  throwing away the old array. Instead of doubling the array, we
         *  could add, e.g., 10 more cells each time. This would use less
         *  memory but would result in much more copying: adding n strings
         *  to the stack would, on average, require copying each one about
         *  n/2 times; with doubling, each one is copied only once, on
         *  average. See the slides for details.
         *
         *  Arrays.copyOf (A, n) creates a new array of length n. If
         *  n <= A.length, it copies the first n entries of A into the new
         *  array. If n > A.length, it copies the whole of A into the start
         *  of the new array and fills the rest with a default value of the
         *  appropriate type -- 0, false or null. Here, we have an array of
         *  Strings, so the default value is null.
         */
        if (size >= entries.length)
            entries = Arrays.copyOf (entries, entries.length * 2);
    }

    /**********************************************************************
     * Exercise 1a
     **********************************************************************/

    /**
     *  pop() removes the top string from the stack and returns it. If the
     *  stack is empty, it returns null.
     *
     *  TODO: modify as described above.
     */
    public String pop () {
        if (size == 0){
            return null;
        } else {
            size--;
            if (size > 10 || entries[(size/4)] == null ){
                entries = Arrays.copyOf (entries, entries.length /2);
            }
            return entries[size];
        }
    }

    /**********************************************************************
     * Exercise 1b
     **********************************************************************/
    public void multiPush (String[] strings) {
        for (String s:strings){
            push(s);
        }
    }

    /**********************************************************************
     * Exercise 1c
     **********************************************************************/
    public String[] multiPop (int n) {
        String[] temp = new String[n];
        for (int i = 0; i < n; i++){
            temp[i] = pop();
        }
        return temp; // replace this placeholder
    }

    /**********************************************************************
     * Exercise 1d
     **********************************************************************/
    public void merge (Stack s) {
        if (s.length() == 0){
            return; //TODO: make it return false because we can't add 0 to it
        }

        entries = Arrays.copyOf (entries, entries.length + s.length()); //add the stack2 space ontop of stack1
        //now push all the elements
        for (int i = s.length(); i > 0; i--){
            push(s.entries[i]);
        }

        s.multiPop(s.arrayLength()); //erase stack2
    }


    /*
     *  Utility methods
     */
    public boolean isEmpty () { return size == 0; }
    public int length () { return size; }
    public int arrayLength () { return entries.length; }
}