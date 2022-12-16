package DSAA.Labs;

import java.util.Arrays;

/***********************************************************************
 *  Lab 1, exercise 2.                                                 *
 ***********************************************************************/

public class LinkedStack {
    private class Item {
        String data;
        Item prev;

        Item (String data, Item prev) {
            this.data = data;
            this.prev = prev;
        }
    }

    private int size = 0;
    private Item top;


    public LinkedStack () {
    }

    public void push (String s) {
        Item temp = new Item(s, top);
        this.top = temp;
        size++;
    }

    public String pop () {
        if (this.top == null){
            return null;
        }
        var temp = this.top.data;
        this.size--;
        this.top = this.top.prev;
        return temp; // Placeholder
    }


    /*******************************************************************
     * Utility methods                                                 *
     *******************************************************************/
    public boolean isEmpty() {
        return size == 0;
    }

    public int length() {
        return size;
    }
}