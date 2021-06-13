package com.company.LL;

public class Lists {

    private void start(){
        System.out.print("hello");
    }

    //this simply satisfies the OOP requirements
    public static void main(String[] args) {
        linkedList tom = new linkedList();
        tom.add("Hello");
        tom.add("My");
        tom.add("Baby");
        tom.add("Hello");
        tom.add("My");
        tom.add("Honey");
        tom.add("Hello");
        tom.add("My");
        tom.add("Ragtime");
        tom.add("Gal");
        System.out.print(tom.getValue(4));

    }
}

class linkedList{

    listNode root;
    listNode tip;
    int length;

    public linkedList(){
        this.length = 0;
        this.root = null;
        this.tip = null;
    }

    //adding new element to the end of the L-list
    public void add(String input){
        //added a check to see if this is the first insert -> put into root.
        if (root == null){
            this.root = new listNode(input); // creating
            this.tip = this.root;
        }else{
            //if it isn't the first position -> leave root alone
            listNode temp = new listNode(input);
            this.tip.linkToNext(temp);
            this.tip = temp;
        }
        this.length++;
    }

    public String getValue(int index){
        if (index >= this.length){
            //this is an out-of-bounds error
            return "";
        }

        listNode temp = this.root;
        for (int i = 0; i < index; i++){
            temp = temp.getNext();
        }
        return temp.getContent();
    }

    public int getLength(){
        return this.length;
    }
}

class listNode{

    private listNode next;
    private String content;

    public listNode(String s){
        this.content = s;
        this.next = null;
    }

    //overloaded constructor in which we are aware of the next element (and what it is going to be)
    public listNode(String s, listNode n){
        this.content = s;
        this.next = n;
    }

    public listNode getNext(){
        return this.next;
    }

    public String getContent(){
        return content;
    }

    public void linkToNext(listNode n){
        this.next = n;
    }
}
