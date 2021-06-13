package com.company.BST;

import java.util.ArrayList;
import java.util.Stack;
import java.lang.Math;

/*
public class BST {

    public class Main {

        private void start(){
            System.out.print("hello");
        }

        public static int alphabeticValue(String input){
            int total = 0;
            for (int i = 0; i < input.length(); i++){
                total = total + (int) input.charAt(i);
            }
            return total;
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

            System.out.print("\n\n\n");

            binaryTree dick = new binaryTree();
            dick.add("James","A piano teacher from Essex.");
            dick.add("Christine","A contract killer from Sussex.");
            dick.add("Terence","A lorry driver, from Jupiter.");
            dick.add("Daisy","An office worker from Galashiels.");
            dick.add("Frederick","A time-travelling shoe salesman from Bristol.");

            System.out.print(dick.retrieveValueByKey("Daisy"));
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

    class binaryTree{
        treeNode root;
        public binaryTree(){
            this.root = null;
        }
        public void add(String k, String v){
            if (root == null){
                this.root = new treeNode(k,v);
            }else{
                treeNode temp = new treeNode(k,v);
                this.root.linkToChild(temp);
            }
        }
        public String retrieveValueByKey(String k){
            return this.root.getValueByKey(k);
        }
    }

    class treeNode{
        private treeNode leftChild;
        private treeNode rightChild;
        private String key;
        private String value;
        public treeNode(String k, String v){
            this.key = k;
            this.value = v;
            this.leftChild = null;
            this.rightChild = null;
        }
        public treeNode getLeft(){
            return this.leftChild;
        }
        public treeNode getRight(){
            return this.rightChild;
        }
        public String getKey(){
            return this.key;
        }
        public String getValueByKey(String k){
            int other = Main.alphabeticValue(k);
            int self = Main.alphabeticValue(this.key);
            if (other == self){
                return this.value;
            }else{
                if (other < self){
                    if (this.leftChild != null){
                        return this.leftChild.getValueByKey(k);
                    }else{
                        return "Sorry, such key exists.";
                    }
                }else{
                    if (this.rightChild != null){
                        return this.rightChild.getValueByKey(k);
                    }else{
                        return "Sorry, such key exists.";
                    }
                }
            }
        }
        public void linkToChild(treeNode n){
            int self = Main.alphabeticValue(this.key);
            int child = Main.alphabeticValue(n.getKey());
            if (child < self){
                if (this.leftChild == null){
                    this.leftChild = n;
                }else{
                    this.leftChild.linkToChild(n);
                }
            }else{
                if (this.rightChild == null){
                    this.rightChild = n;
                }else{
                    this.rightChild.linkToChild(n);
                }
            }
        }
    }
}
*/
