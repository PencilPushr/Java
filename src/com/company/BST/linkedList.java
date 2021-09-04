package com.company.BST;

public class linkedList {

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

