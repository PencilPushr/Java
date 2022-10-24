package DSAA.Labs;
public class SinglyLinkedList {
    private static class Item {
        String value;
        Item next; /* No 'prev' reference in a singly linked list. */

        Item (String value, Item next) {
            this.value = value;
            this.next = next;
        }
    }

    /*
     *  We still keep a reference to the head and tail of the
     *  list, though tail is only needed for addToTail.
     */
    private Item head = null;
    private Item tail = null;
    private int length = 0;

    /*******************************************************************
     *  Part a                                                         *
     *******************************************************************
     *  Note that there's no need to write code for the create() oper-
     *  ation, as this functionality is provided by the initializers
     *  above, which create an empty list.
     */

    public String get (int index) {

        if (index >= this.length){
            //this is an out-of-bounds error
            return "";
        }

        Item temp = this.head;

        for (int i = 0; i < index; i++){
            temp = temp.next;
        }

        return temp.value;
    }

    public void insert (int index, String value) {
        if (index < 0 || index > this.length){
            //if we try to insert beyond the end of
            //list we will get an out-of-bounds error
            throw new IndexOutOfBoundsException();
        } else if (this.head == null){
            //if this is the first position -> put into root/head
            this.head = new Item(value, null); // creating
            this.tail = this.head;
        } else if (index == 0){
            //insert at the head node
            Item newHead = new Item(value, null);
            newHead.next = this.head;
            this.head = newHead;
        } else if (index == this.length){
            //we are inserting at the tail.
            Item newtemp = new Item(value, null);
            this.tail.next = newtemp;
            this.tail = newtemp;
        } else {
            Item curr = this.head;
            for (int i = 0; i < index-1; i++) {
                curr = curr.next;
            }
            Item newNode = new Item(value, null);
            newNode.next = curr.next;
            curr.next = newNode;
        }
        this.length++;
    }

    public void delete (int index) {
        if (index < 0 || index >= this.length){
            //if we try to insert beyond the end of
            //list we will get an out-of-bounds error
            throw new IndexOutOfBoundsException();
        } else if (index == 0){
            //deleting from start of list
            this.head = this.head.next;
            this.length--;
            return;
        } else {
            Item curr = head;
            for (int i = 1; i < index; i++) {
                curr = curr.next;
            }
            Item temp = curr.next.next;
            curr.next = temp;
            //special case for end
            if (index == (this.length-1)){
                this.tail = curr;
            }
        }
        this.length--;
    }

    public boolean isEmpty () { return head == null; }
    public int length ()      { return length; }

    /*******************************************************************
     *  Part b                                                         *
     ******************************************************************/
    public void addToHead (String value) {
        if (this.head == null) {
            this.head = new Item(value, null);
            this.tail = this.head;
        } else {
            Item temp = this.head;
            this.head = new Item(value, temp);
        }
    }

    public void addToTail (String value) {
        //if this is the first position -> put into root/head
        if (this.head == null) {
            this.head = new Item(value, null); // creating
            this.tail = this.head;
        } else {
            Item temp = new Item(value, null);
            this.tail.next = temp;
            this.tail = temp;
        }
    }

    /*******************************************************************
     *  Utility methods. Please do not modify.                         *
     ******************************************************************/
    public String toString () {
        String s = "";
        Item cur = head;
        while (cur != null) {
            s += cur.value;
            cur = cur.next;
            if (cur != null)
                s += ",";
        }
        return s;
    }

    /*
     *  Method to produce a 3-item test list by manually creating Item
     *  objects and stitching them together.
     */
    public static SinglyLinkedList getTestList () {
        SinglyLinkedList list = new SinglyLinkedList();
        Item item3 = new Item ("3", null);
        Item item2 = new Item ("2", item3);
        Item item1 = new Item ("1", item2);
        list.head = item1;
        list.tail = item3;
        list.length = 3;
        return list;
    }
}